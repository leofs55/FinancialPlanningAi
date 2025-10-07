package dev.lest.FinancialPlanningAi.account.entity;

import dev.lest.FinancialPlanningAi.profile.entity.ProfileEntity;
import dev.lest.FinancialPlanningAi.purchase.entity.PurchaseEntity;
import dev.lest.FinancialPlanningAi.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID publicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "name")
    private String name;

    @Column(name = "agency_number")
    private String agencyNumber;

    @Column(name = "account_number")
    private String accountNumber;

//    TODO:Descomentar quando Todas as camadas de servicos estiverem feitas
//    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<PurchaseEntity> purchases;

}
