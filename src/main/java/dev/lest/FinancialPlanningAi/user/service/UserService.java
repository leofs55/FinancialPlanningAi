package dev.lest.FinancialPlanningAi.user.service;

import dev.lest.FinancialPlanningAi.user.entity.UserEntity;
import dev.lest.FinancialPlanningAi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository repository;

    public UserEntity create(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public Optional<UserEntity> find(UUID publicId) {
        return repository.findByPublicIdCustom(publicId);
    }

    public UserEntity update() {
        return new UserEntity();
    }

    public UserEntity delete() {
        return new UserEntity();
    }
}
