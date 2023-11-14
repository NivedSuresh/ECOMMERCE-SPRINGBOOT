package com.ecommerce.library.Repository.UserRepos;

import com.ecommerce.library.Model.User.ReturnRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRequestRepo extends JpaRepository<ReturnRequest, Long> {


    ReturnRequest findByOrderId(Long orderId);
}
