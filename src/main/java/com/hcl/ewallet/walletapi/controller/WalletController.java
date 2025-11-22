package com.hcl.ewallet.walletapi.controller;

import com.hcl.ewallet.walletapi.model.*;
import jakarta.validation.Valid;
import com.hcl.ewallet.walletapi.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getWallet(@PathVariable long customerId) {
        CustomerWalletResponse resp = service.getWallet(customerId);
        if (resp == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/validate-purchase")
    public ResponseEntity<ValidatePurchaseResponse> validatePurchase(@Valid @RequestBody ValidatePurchaseRequest req) {
        ValidatePurchaseResponse resp = service.validatePurchase(req);
        return ResponseEntity.ok(resp);
    }

//     @PutMapping("/debit")
//     public ResponseEntity<DebitResponse> debit(@RequestBody DebitRequest req) {
//         DebitResponse resp = service.debit(req);
//         return ResponseEntity.ok(resp);
//     }

//     @PutMapping("/refund")
//     public ResponseEntity<DebitResponse> refund(@RequestBody DebitRequest req) {
//         DebitResponse resp = service.refund(req);
//         return ResponseEntity.ok(resp);
//     }
 }
