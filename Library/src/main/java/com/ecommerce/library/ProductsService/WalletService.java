package com.ecommerce.library.ProductsService;

import com.ecommerce.library.Model.User.Customer;
import com.ecommerce.library.Model.User.Order;
import com.ecommerce.library.Model.User.Wallet;

public interface WalletService {

    Wallet getWallet(String email);

    Wallet getWallet(Customer customer);

    Wallet saveWallet(Wallet wallet);

    Double getBalance(Customer customer);

    void initiateWalletRefund(Order order, Double refundAmount);
}
