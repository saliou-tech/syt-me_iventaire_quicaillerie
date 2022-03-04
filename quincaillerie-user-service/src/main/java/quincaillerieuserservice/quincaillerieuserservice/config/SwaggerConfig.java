package quincaillerieuserservice.quincaillerieuserservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    /**
     * @api /swagger-ui/index.html
     * @api /v3/api-docs
     */

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Gestion de  stock pour une quincqillerie - microservice authentification")
                .description("Gestion des operations d'authentifications comme conexion ,deconnexion m,odification mot de passe")
                .license("Apache 2.0")
                .licenseUrl("a remplir")
                .version("1.0")
                .contact(
                        new Contact(
                                "Serigne saliou  Gueye",
                                "www.github.com/saliou-tech",
                                "gueyesaliou066@gmail.com")
                )
                .build();
    }
}
