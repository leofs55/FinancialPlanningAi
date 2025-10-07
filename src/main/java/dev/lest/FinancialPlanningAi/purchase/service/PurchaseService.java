package dev.lest.FinancialPlanningAi.purchase.service;

import dev.lest.FinancialPlanningAi.purchase.entity.PurchaseEntity;
import dev.lest.FinancialPlanningAi.purchase.repository.PurchaseRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class PurchaseService {

    private PurchaseRepository purchaseRepository;

    public PurchaseEntity createPurchase(PurchaseEntity purchase) {
        // Criar depois um processo rigido de validacao de cada purchase
        return purchaseRepository.save(purchase);
    }

    public PurchaseEntity readPurchase(UUID publicId) {
        Optional<PurchaseEntity> optionalPurchase = purchaseRepository.findBypublicId(publicId);
        if (optionalPurchase.isPresent()) {
            return optionalPurchase.get();
        }
        return PurchaseEntity.builder().build();
    }

    public PurchaseEntity updatePurchase(PurchaseEntity purchase) {
        Optional<PurchaseEntity> optionalPurchase = purchaseRepository.findBypublicId(purchase.getPublicId());
        if (optionalPurchase.isPresent()) {
            PurchaseEntity purchaseToUpdate = optionalPurchase.get();

            Long bankId = (purchase.getBankId() == null) ? purchaseToUpdate.getBankId() : purchase.getBankId();
            LocalDate purchaseDate = (purchase.getPurchaseDate() == null) ? purchaseToUpdate.getPurchaseDate() : purchase.getPurchaseDate();
            String description = (purchase.getDescription() == null) ? purchaseToUpdate.getDescription() : purchase.getDescription();

            return purchaseRepository.save(
                    PurchaseEntity.builder()
                            .id(purchaseToUpdate.getId())
                            .publicId(purchaseToUpdate.getPublicId())
                            .bankId(bankId)
                            .purchaseDate(purchaseDate)
                            .description(description)
                            .build()
            );
        }
        return PurchaseEntity.builder().build();
    }

    public String deletePurchase(UUID publicId) {
        Optional<PurchaseEntity> optionalPurchase = purchaseRepository.findBypublicId(publicId);
        if (optionalPurchase.isPresent()) {
            purchaseRepository.delete(optionalPurchase.get());
            return "Result of deletePurchase: Purchase was deleted!";
        }
        return "Result of deletePurchase: Purchase not found!";
    }

    public List<PurchaseEntity> listPurchases() {
        return purchaseRepository.findAll();
    }
}
