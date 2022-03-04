package quincaillerieuserservice.quincaillerieuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Address;
import quincaillerieuserservice.quincaillerieuserservice.Entity.Adress;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5, max = 20)
    private String password;
    @NotBlank
    @Pattern(regexp = "^(Homme|Femme)$", message = "le sex  doit etre homme ou femme")
    private String gender;
    @NotBlank
    @Email
    private String emailI;
    @NotBlank
    @Size(min = 10, max = 10, message = "Length of phone number must be 10")
    private String telephone;
    @NotNull
    @Past
    private LocalDate dob;
    @Valid
    private Adress address;
    @NotBlank
    @Size(min = 5, max = 30)
    private String nom;
    @NotBlank
    @Size(min = 5, max = 30)
    private String prenom;
}
