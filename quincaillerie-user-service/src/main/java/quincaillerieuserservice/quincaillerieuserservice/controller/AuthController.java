package quincaillerieuserservice.quincaillerieuserservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quincaillerieuserservice.quincaillerieuserservice.dto.LoginRequest;
import quincaillerieuserservice.quincaillerieuserservice.dto.LoginResponse;
import quincaillerieuserservice.quincaillerieuserservice.service.AuthService;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        log.info("controller");
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }

  /*  @GetMapping("/forgotpassword/{username}")
    public ResponseEntity<Map<String, String>> forgotPassword(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchSecurityQuestionForUser(username));
    }

    @PutMapping("/forgotpassword")
    public ResponseEntity<Map<String, String>> validateAnswerAndUpdatePassword(
            @Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.validateAnswerAndUpdate(forgotPasswordRequest));
    }*/
}
