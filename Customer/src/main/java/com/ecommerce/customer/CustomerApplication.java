package com.ecommerce.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.ecommerce.library.*",
        "com.ecommerce.customer.*", "com.ecommerce.products.*"})
@EnableJpaRepositories(value = {"com.ecommerce.library.Repository.*"})
@EntityScan(basePackages = {"com.ecommerce.library.Model.User","com.ecommerce.library.Model.Utils"})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
