package quincaillerieuserservice.quincaillerieuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

        @NotBlank
        @Size(min = 5, max = 20)
        private String username;
        @NotBlank
        @Size(min = 5, max = 20)
        private String password;

}
