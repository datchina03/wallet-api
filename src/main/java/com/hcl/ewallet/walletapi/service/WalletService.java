package com.hcl.ewallet.walletapi.service;

import com.hcl.ewallet.walletapi.entity.CustomerWallet;
import com.hcl.ewallet.walletapi.model.*;
import com.hcl.ewallet.walletapi.repository.CustomerWalletRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class WalletService {

    private final CustomerWalletRepository repository;

    public WalletService(CustomerWalletRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        // create sample data if not present
        if (!repository.existsById(1001L)) {
            repository.save(new CustomerWallet(1001L, "John Doe", new BigDecimal("500.00"), "USD", "john.doe@example.com"));
        }
    }

    public CustomerWalletResponse getWallet(long customerId) {
        Optional<CustomerWallet> found = repository.findById(customerId);
        if (found.isEmpty()) return null;
        CustomerWallet cw = found.get();
        return new CustomerWalletResponse(cw.getCustomerId(), cw.getFullName(), new WalletInfo(cw.getBalance(), cw.getCurrency()), cw.getEmail());
    }

    public CustomerWalletResponse findByEmail(String email) {
        Optional<CustomerWallet> opt = repository.findByEmail(email);
        if (opt.isEmpty()) return null;
        CustomerWallet cw = opt.get();
        return new CustomerWalletResponse(cw.getCustomerId(), cw.getFullName(), new WalletInfo(cw.getBalance(), cw.getCurrency()), cw.getEmail());
    }

    public ValidatePurchaseResponse validatePurchase(ValidatePurchaseRequest req) {
        Optional<CustomerWallet> opt = repository.findById(req.getCustomerId());
        if (opt.isEmpty()) return new ValidatePurchaseResponse(false, "Customer not found.");
        CustomerWallet cust = opt.get();
        if (!cust.getCurrency().equalsIgnoreCase(req.getCurrency())) {
            return new ValidatePurchaseResponse(false, "Invalid currency.");
        }
        if (cust.getBalance().compareTo(req.getAmount()) < 0) {
            return new ValidatePurchaseResponse(false, "Insufficient wallet balance.");
        }
        if (req.getMerchantId() == null || req.getMerchantId() <= 0 || req.getProductCode() == null || req.getProductCode().isEmpty()) {
            return new ValidatePurchaseResponse(false, "Invalid merchant/product.");
        }
        return new ValidatePurchaseResponse(true, "Validation successful. Proceed payment.");
    }

//    public DebitResponse debit(DebitRequest req) {
//        Optional<CustomerWallet> opt = repository.findById(req.getCustomerId());
//        if (opt.isEmpty()) return new DebitResponse("FAILED", null);
//        CustomerWallet cust = opt.get();
//        BigDecimal newBal = cust.getBalance().subtract(req.getAmount());
//        cust.setBalance(newBal);
//        repository.save(cust);
//        return new DebitResponse("SUCCESS", newBal);
//    }
//
//    public DebitResponse refund(DebitRequest req) {
//        Optional<CustomerWallet> opt = repository.findById(req.getCustomerId());
//        if (opt.isEmpty()) return new DebitResponse("FAILED", null);
//        CustomerWallet cust = opt.get();
//        BigDecimal newBal = cust.getBalance().add(req.getAmount());
//        cust.setBalance(newBal);
//        repository.save(cust);
//        return new DebitResponse("SUCCESS", newBal);
//    }
}
