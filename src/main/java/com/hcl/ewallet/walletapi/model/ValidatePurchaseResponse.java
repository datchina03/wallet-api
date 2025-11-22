package com.hcl.ewallet.walletapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidatePurchaseResponse {
	private boolean valid;
	private String message;
}
