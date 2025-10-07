package dev.lest.FinancialPlanningAi.user.entity;

import dev.lest.FinancialPlanningAi.account.entity.AccountEntity;
import dev.lest.FinancialPlanningAi.profile.entity.ProfileEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID publicId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "date_time_creation")
    private LocalDateTime dateTimeCreation;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "salary")
    private BigDecimal salary;

//    TODO:Descomentar quando Todas as camadas de servicos estiverem feitas
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<AccountEntity> accounts;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<ProfileEntity> profiles;


}
