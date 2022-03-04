package quincaillerieuserservice.quincaillerieuserservice.service;

import quincaillerieuserservice.quincaillerieuserservice.dto.*;

import java.util.List;
import java.util.Map;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    UserDetailDto register(RegisterRequest registerRequest);

    Map<String, String> updateUser(UpdateRequest updateRequest);

    List<UserDetailDto> fetchAllUsers();

    UserDetailDto fetchUserById(Long id);

    boolean checkIfUsernameExists(String username);

/*    Map<String, String> fetchSecurityQuestionForUser(String username);

    Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest);*/
}
