package dev.lest.FinancialPlanningAi.purchase.controller;

import dev.lest.FinancialPlanningAi.purchase.mapper.PurchaseMapper;
import dev.lest.FinancialPlanningAi.purchase.service.PurchaseService;
import dev.lest.FinancialPlanningAi.purchase.util.requestDto.PurchaseCreateRequest;
import dev.lest.FinancialPlanningAi.purchase.util.requestDto.PurchaseUpdateRequest;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseCreateResponse;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseDeleteResponse;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseReadResponse;
import dev.lest.FinancialPlanningAi.purchase.util.responseDto.PurchaseUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private PurchaseService pruchaseService;

    /*
    + purchaseEndPointCreatePurchase(PurchaseCreateRequest): PurchaseCreateResponse
    + purchaseEndPointUpdatePurchase(PurchaseUpdateRequest): PurchaseUpdateResponse
    + purchaseEndPointReadPurchase(UUID): PurchaseReadResponse
    + purchaseEndPointListPurchases(): List<PurchaseReadResponse>
    + purchaseEndPointDeletePurchase(PurchaseDeleteRequest): PurchaseDeleteResponse
     */

    @PostMapping("/create-purchase")
    public Map<PurchaseCreateResponse, String> purchaseEndPointCreatePurchase(@RequestBody PurchaseCreateRequest purchaseDto) {
        Map<PurchaseCreateResponse, String> response = Map.of(
                PurchaseMapper.mapCreate(pruchaseService.createPurchase(PurchaseMapper.mapCreate(purchaseDto))),
                "Result of createPurchase: Purchase created successfully!"
        );
        return response;
    }

    @PutMapping("/update-purchase")
    public Map<PurchaseUpdateResponse, String> purchaseEndPointUpdatePurchase(@RequestBody PurchaseUpdateRequest purchaseDto) {
        Map<PurchaseUpdateResponse, String> response = Map.of(
                PurchaseMapper.mapUpdate(pruchaseService.updatePurchase(PurchaseMapper.mapUpdate(purchaseDto))),
                "Result of updatePurchase: Purchases changed successfully!"
        );
        return response;
    }

    @GetMapping("/find-purchase/{publicId}")
    public Map<PurchaseReadResponse, String> purchaseEndPointReadPurchase(@PathVariable UUID publicId) {
        Map<PurchaseReadResponse, String> response = Map.of(
                PurchaseMapper.mapRead(pruchaseService.readPurchase(publicId)),
                "Result of readPurchase: Purchase found successfully!"
        );
        return response;
    }

    //Mudar isso pq gera uma falha de segurancaKKK, PRECISA ter o id do usuário para ter TODAS as compras dele
    @GetMapping("/all")
    public Map<List<PurchaseReadResponse>, String> purchaseEndPointListPurchases() {
        List<PurchaseReadResponse> listResponses = pruchaseService.listPurchases().stream()
                .map(PurchaseMapper::mapRead)
                .collect(Collectors.toList());

        Map<List<PurchaseReadResponse>, String> response = Map.of(
                listResponses,
                "Result of listPurchases: Purchases found successfully!"
        );
        return response;
    }

    @DeleteMapping("/delete-purchase/{publicId}")
    public Map<UUID, PurchaseDeleteResponse> purchaseEndPointDeletePurchase(@PathVariable UUID publicId) {
        Map<UUID, PurchaseDeleteResponse> response = Map.of(
                publicId,
                PurchaseDeleteResponse.builder().result(pruchaseService.deletePurchase(publicId)).build()
        );
        return response;
    }
}
