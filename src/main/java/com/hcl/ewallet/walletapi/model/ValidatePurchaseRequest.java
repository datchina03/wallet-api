package com.hcl.ewallet.walletapi.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidatePurchaseRequest {
	@NotNull
	private Long customerId;

	@NotNull
	private Long merchantId;

	@NotBlank
	private String productCode;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal amount;

	@NotBlank
	private String currency;
}
