package com.hcl.ewallet.walletapi.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "merchant_id", nullable = false)
    private Long merchantId;

    @Column(name = "product_code", length = 10)
    private String productCode;

    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public Product() {}

    public Product(Long merchantId, String productCode, String productName) {
        this.merchantId = merchantId;
        this.productCode = productCode;
        this.productName = productName;
        this.createdAt = OffsetDateTime.now();
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getMerchantId() { return merchantId; }
    public void setMerchantId(Long merchantId) { this.merchantId = merchantId; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
