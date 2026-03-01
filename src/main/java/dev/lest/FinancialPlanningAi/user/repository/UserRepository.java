package dev.lest.FinancialPlanningAi.user.repository;

import dev.lest.FinancialPlanningAi.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM users u WHERE u.cpf = :cpf", nativeQuery = true)
    Optional<UserEntity> findByCpfCustom(@Param("cpf") String cpf);

    @Query(value = "SELECT * FROM users u WHERE u.public_id = :publicId", nativeQuery = true)
    Optional<UserEntity> findByPublicIdCustom(@Param("publicId") UUID publicId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET salary = :salary WHERE id = :id", nativeQuery = true)
    void updateSalaryCustom(@Param("id") Long id, @Param("salary") BigDecimal salary);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET first_name = :firstName, last_name = :lastName, cpf = :cpf WHERE id = :id", nativeQuery = true)
    int updateUserInfoCustom(
            @Param("id") Long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("cpf") String cpf
    );

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (public_id, first_name, last_name, cpf, date_time_creation, date_birth, salary) " +
            "VALUES (:publicId, :firstName, :lastName, :cpf, CURRENT_TIMESTAMP, :dateBirth, :salary)",
            nativeQuery = true)
    void insertUserCustom(
            @Param("publicId") UUID publicId,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("cpf") String cpf,
            @Param("dateBirth") java.time.LocalDate dateBirth,
            @Param("salary") BigDecimal salary
    );

}
