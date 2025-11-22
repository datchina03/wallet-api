package com.hcl.ewallet.walletapi.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWalletResponse {
	private long customerId;
	private String fullName;
	private double balance;
	private String currency;
	private String email;
}
