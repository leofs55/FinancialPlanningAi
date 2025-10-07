package dev.lest.FinancialPlanningAi.purchase.mapper;

import dev.lest.FinancialPlanningAi.purchase.entity.PurchaseEntity;
import dev.lest.FinancialPlanningAi.purchase.util.requestDto.PurchaseCreateRequest;
import dev.lest.FinancialPlanningAi.purchase.util.requestDto.PurchaseUpdateRequest;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseCreateResponse;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseReadResponse;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseUpdateResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PurchaseMapper {

    public static PurchaseEntity mapCreate(PurchaseCreateRequest request) {
        return PurchaseEntity.builder()
                .bankId(request.bankId())
                .purchaseDate(request.purchaseDate())
                .description(request.description())
                .build();
    }

    public static PurchaseCreateResponse mapCreate(PurchaseEntity entity) {
        return PurchaseCreateResponse.builder()
                .publicId(entity.getPublicId())
                .bankId(entity.getBankId())
                .purchaseDate(entity.getPurchaseDate())
                .description(entity.getDescription())
                .build();
    }

    public static PurchaseEntity mapUpdate(PurchaseUpdateRequest request) {
        return PurchaseEntity.builder()
                .bankId(request.bankId())
                .purchaseDate(request.purchaseDate())
                .description(request.description())
                .build();
    }

    public static PurchaseUpdateResponse mapUpdate(PurchaseEntity entity) {
        return PurchaseUpdateResponse.builder()
                .publicId(entity.getPublicId())
                .bankId(entity.getBankId())
                .purchaseDate(entity.getPurchaseDate())
                .description(entity.getDescription())
                .build();
    }

    public static PurchaseReadResponse mapRead(PurchaseEntity entity) {
        return PurchaseReadResponse.builder()
                .publicId(entity.getPublicId())
                .bankId(entity.getBankId())
                .purchaseDate(entity.getPurchaseDate())
                .description(entity.getDescription())
                .build();
    }

}
