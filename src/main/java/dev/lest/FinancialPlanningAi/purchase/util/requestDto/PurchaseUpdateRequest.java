package dev.lest.FinancialPlanningAi.purchase.util.requestDto;

import java.time.LocalDate;

public record PurchaseUpdateRequest(Long bankId,
                                    LocalDate purchaseDate,
                                    String description/*,
                                    UUID AccountId*/) {
}
