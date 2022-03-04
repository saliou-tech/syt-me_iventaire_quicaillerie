package quincaillerieuserservice.quincaillerieuserservice.service.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quincaillerieuserservice.quincaillerieuserservice.Entity.User;
import quincaillerieuserservice.quincaillerieuserservice.Entity.UserDetail;
import quincaillerieuserservice.quincaillerieuserservice.Helper.UserDetailsMapper;
import quincaillerieuserservice.quincaillerieuserservice.dto.*;
import quincaillerieuserservice.quincaillerieuserservice.exception.InvalidCredentialException;
import quincaillerieuserservice.quincaillerieuserservice.repository.AddressRepository;
import quincaillerieuserservice.quincaillerieuserservice.repository.UserDetailsRepository;
import quincaillerieuserservice.quincaillerieuserservice.repository.UserRepository;
import quincaillerieuserservice.quincaillerieuserservice.security.JwtProvider;
import quincaillerieuserservice.quincaillerieuserservice.service.AuthService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserDetailsRepository userDetailsRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = findUserByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
        return LoginResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .role(user.getRole())
                .token(jwtProvider.generateTokenWithUsername(user.getUsername()))
                .build();
    }

    @Override
    public UserDetailDto register(RegisterRequest registerRequest) {
        checkIfUsernameExists(registerRequest.getUsername());
        log.info("dans  le  servcie");

        registerRequest.setPassword(encodePassword(registerRequest.getPassword()));
        registerRequest.setAddress(addressRepository.save(registerRequest.getAddress()));
        UserDetail userDetails = userDetailsRepository.save(UserDetailsMapper.registerToUserDetails(registerRequest));
        return UserDetailsMapper.userDetailsToDto(userDetails);
    }

   @Override
    public Map<String, String> updateUser(UpdateRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDto> fetchAllUsers() {
        return userDetailsRepository
                .findAll()
                .stream()
                .map(UserDetailsMapper::userDetailsToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDetailDto fetchUserById(Long id) {
        return UserDetailsMapper.userDetailsToDto(
                userDetailsRepository
                        .findById(id)
                        .orElseThrow(() -> new InvalidCredentialException("userId", "ID " + id + " doesn't exist")));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkIfUsernameExists(String username) {
        if (!userRepository.existsByUsername(username)) return false;
        else throw new InvalidCredentialException("username", "Username already exists");
    }

    @Transactional(readOnly = true)
    public User findUserByCredentials(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialException("username", "User " + username + " doesn't exist"));

        if (!passwordEncoder.matches(password, user.getPassword())) throw new InvalidCredentialException("password", "Invalid Password");
        return user;
    }
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

}
