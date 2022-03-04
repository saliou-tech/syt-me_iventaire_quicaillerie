package quincaillerieuserservice.quincaillerieuserservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "user_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "user_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column(length = 20, unique = true)
    private String username;
    @Column(length = 60)
    private  String password;
    @Column(length = 60)
    private String role;



}
