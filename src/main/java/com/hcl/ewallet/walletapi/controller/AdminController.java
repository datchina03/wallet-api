package com.hcl.ewallet.walletapi.controller;

import com.hcl.ewallet.walletapi.entity.CustomerWallet;
import com.hcl.ewallet.walletapi.repository.CustomerWalletRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final CustomerWalletRepository repository;

    public AdminController(CustomerWalletRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public List<CustomerWallet> listAll() {
        return repository.findAll();
    }
}
