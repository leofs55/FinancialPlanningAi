package dev.lest.FinancialPlanningAi.purchase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "purchases")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID publicId;

    @Column(name = "bank_id")
    private Long bankId;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "description")
    private String description;

//    TODO:Descomentar quando Todas as camadas de servicos estiverem feitas
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "account_id", nullable = false)
//    private AccountEntity account;

}
