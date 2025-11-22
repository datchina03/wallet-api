package com.hcl.ewallet.walletapi.repository;

import com.hcl.ewallet.walletapi.entity.CustomerWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerWalletRepository extends JpaRepository<CustomerWallet, Long> {
	Optional<CustomerWallet> findByEmail(String email);
}
