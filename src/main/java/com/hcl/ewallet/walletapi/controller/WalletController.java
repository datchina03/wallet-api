package com.hcl.ewallet.walletapi.controller;

import com.hcl.ewallet.walletapi.model.*;
import jakarta.validation.Valid;
import com.hcl.ewallet.walletapi.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.ewallet.walletapi.entity.Product;
import com.hcl.ewallet.walletapi.repository.ProductRepository;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService service;
    private final ProductRepository productRepository;

    public WalletController(WalletService service, ProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
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

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listProducts(@RequestParam(required = true) Long merchantId) {
        List<Product> products;
        if (merchantId == null) products = productRepository.findAll();
        else products = productRepository.findByMerchantId(merchantId);
        return ResponseEntity.ok(products);
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
