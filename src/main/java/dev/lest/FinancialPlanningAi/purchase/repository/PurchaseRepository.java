package dev.lest.FinancialPlanningAi.purchase.repository;

import dev.lest.FinancialPlanningAi.purchase.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
    Optional<PurchaseEntity> findBypublicId(UUID publicId);
}
