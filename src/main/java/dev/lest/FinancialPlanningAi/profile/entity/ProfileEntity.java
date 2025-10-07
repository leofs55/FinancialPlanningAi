package dev.lest.FinancialPlanningAi.profile.entity;

import dev.lest.FinancialPlanningAi.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "public_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID publicId;

//    TODO:Descomentar quando Todas as camadas de servicos estiverem feitas
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
