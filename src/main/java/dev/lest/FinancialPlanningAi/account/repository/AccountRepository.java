package dev.lest.FinancialPlanningAi.account.repository;

import dev.lest.FinancialPlanningAi.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
