package com.hcl.ewallet.walletapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerWalletResponse {
	private long customerId;
	private String fullName;
	private WalletInfo wallet;
	private String email;
}
