package quincaillerieuserservice.quincaillerieuserservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import quincaillerieuserservice.quincaillerieuserservice.dto.RegisterRequest;
import quincaillerieuserservice.quincaillerieuserservice.dto.UserDetailDto;
import quincaillerieuserservice.quincaillerieuserservice.service.AuthService;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/register")
@RestController
@AllArgsConstructor
@CrossOrigin(origins =  "*")

public class RegisterController {

    private final AuthService authService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDetailDto> register( @RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }

  /*  @PutMapping
    public ResponseEntity<Map<String, String>> updateUser(@Valid @RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.updateUser(updateRequest));
    }*/

    @GetMapping("/all-user")
    public ResponseEntity<List<UserDetailDto>> fetchAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDetailDto> fetchUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchUserById(id));
    }
}
