package quincaillerieuserservice.quincaillerieuserservice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Adress {
    @Id
    @JsonIgnore
    @SequenceGenerator(name = "address_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "address_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long addressId;
    @Column(length = 25)

    private String  address;
    @Column(length = 6)

    private String boitepostale;


}







