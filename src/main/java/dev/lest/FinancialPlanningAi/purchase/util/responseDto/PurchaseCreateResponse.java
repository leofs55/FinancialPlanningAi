package dev.lest.FinancialPlanningAi.purchase.util.responseDto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record PurchaseCreateResponse(UUID publicId,
                                     Long bankId,
                                     LocalDate purchaseDate,
                                     String description/*,
                                     UUID AccountId*/) {
}
