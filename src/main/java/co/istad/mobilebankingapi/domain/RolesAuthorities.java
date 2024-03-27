package co.istad.mobilebankingapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Entity
@Table(name = "roles_authorities")
public class RolesAuthorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer authorityId;

    @ManyToOne
    private Role role;

}
