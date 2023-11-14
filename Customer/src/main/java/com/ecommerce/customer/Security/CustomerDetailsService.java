package com.ecommerce.customer.Security;

import com.ecommerce.library.Exceptions.CustomerBlockedException;
import com.ecommerce.library.Model.User.Customer;
import com.ecommerce.library.Repository.UserRepos.CustomerRepository;
import com.ecommerce.library.Service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.*;

@Service
public class CustomerDetailsService implements UserDetailsService {
    CustomerService customerService;

    @Autowired
    public CustomerDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findByEmail(username);
        if(customer==null)throw new UsernameNotFoundException("Invalid user");
        return CustomerDetails.builder().
                email(customer.getEmail())
                .password(customer.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(customer.getRole())))
                .build();
    }

}
