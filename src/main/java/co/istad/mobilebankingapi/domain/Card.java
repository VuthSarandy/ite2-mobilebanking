package co.istad.mobilebankingapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private String cvv;

    private String holder;

    private LocalDate issueDate;

    private LocalDate expiredAt;

    private Boolean isDeleted;

    @ManyToOne // many cardType to one card
    @JoinColumn(name = "type_id")
    private CardType cardType;

    @OneToOne(mappedBy = "card")
    private Account account;
}