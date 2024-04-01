//package co.istad.mobilebankingapi.domain;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "notification")
//public class Notification {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    private User senderId;
//
//    @ManyToOne
//    private User receiverId;
//
//    @ManyToOne
//    private Transaction transaction;
//
//    private LocalDateTime transactionAt;
//
//    private String content;
//}
