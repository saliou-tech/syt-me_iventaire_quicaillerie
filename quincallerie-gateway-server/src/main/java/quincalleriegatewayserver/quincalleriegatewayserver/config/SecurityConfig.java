package quincalleriegatewayserver.quincalleriegatewayserver.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import quincalleriegatewayserver.quincalleriegatewayserver.security.CustomAuthenticationEntryPoint;
import quincalleriegatewayserver.quincalleriegatewayserver.security.JwtAuthenticationFilter;
import quincalleriegatewayserver.quincalleriegatewayserver.service.Implementation.JwtUserDetailsServiceImpl;

import java.util.Arrays;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    private JwtUserDetailsServiceImpl userDetailsService;


    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .configurationSource(request -> {
                    CorsConfiguration source = new CorsConfiguration();
                    source.applyPermitDefaultValues();
                    // .applyPermitDefaultValues(); only allows GET, HEAD, POST
                    source.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "DELETE", "PUT"));
                    return source;
                }).and() // Required for accessing prpotected routes
                .csrf().disable()
                .authorizeRequests().antMatchers("/inventory-auth-service/**", "/actuator/**", "/**/h2/**", "/**/swagger*/**", "/**/v2/api-docs").permitAll().antMatchers("/h2").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
    }
    /**
     * Password Encodeer DI
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * In @Bean(BeanIds.AUTHENTICATION_MANAGER) NeanIds part is optional
     * @return
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * DI for CustomAuthentiaction EntryPoint
     */
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
}
