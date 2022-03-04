package quincalleriegatewayserver.quincalleriegatewayserver.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import quincalleriegatewayserver.quincalleriegatewayserver.entity.User;
import quincalleriegatewayserver.quincalleriegatewayserver.exception.InvalidCredentialException;
import quincalleriegatewayserver.quincalleriegatewayserver.repository.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
