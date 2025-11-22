package com.hcl.ewallet.walletapi.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitRequest {
	@NotNull
	private Long customerId;

	@NotNull
	@DecimalMin("0.01")
	private BigDecimal amount;
}
