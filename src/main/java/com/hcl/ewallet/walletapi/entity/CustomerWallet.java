package com.hcl.ewallet.walletapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "customers")
public class CustomerWallet {
    @Id
    private Long customerId;
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    private BigDecimal balance;
    private String currency;

    public CustomerWallet() {}

    public CustomerWallet(Long customerId, String fullName, BigDecimal balance, String currency) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.currency = currency;
    }

    public CustomerWallet(Long customerId, String fullName, BigDecimal balance, String currency, String email) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
        this.currency = currency;
        this.email = email;
    }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
