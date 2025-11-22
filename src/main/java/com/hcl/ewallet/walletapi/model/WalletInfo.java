package com.hcl.ewallet.walletapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletInfo {
	private BigDecimal balance;
	private String currency;
}
