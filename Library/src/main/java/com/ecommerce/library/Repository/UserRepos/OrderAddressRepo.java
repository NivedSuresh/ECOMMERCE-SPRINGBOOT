package com.ecommerce.library.Repository.UserRepos;

import com.ecommerce.library.Model.User.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepo extends JpaRepository<OrderAddress, Long> {
}
