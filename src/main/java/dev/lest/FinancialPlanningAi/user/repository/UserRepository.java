package dev.lest.FinancialPlanningAi.user.repository;

import dev.lest.FinancialPlanningAi.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
