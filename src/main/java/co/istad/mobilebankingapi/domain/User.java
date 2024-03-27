package co.istad.mobilebankingapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.logging.Level;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(length = 50)
    private String name;

    @Column(length = 8)
    private String gender;

    @Column(unique = true)
    private String oneSignalId;

    @Column(unique = true)
    private String studentIdCard;

    private boolean isStudent;

    private boolean isDeleted;

    @OneToMany(mappedBy = "user") // one user have many account
    private List<UserAccount> userAccountList;
}
