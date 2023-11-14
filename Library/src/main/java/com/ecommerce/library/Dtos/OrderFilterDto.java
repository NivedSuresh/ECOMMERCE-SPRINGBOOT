package com.ecommerce.library.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Getter @Setter
public class OrderFilterDto {
    String status;
    String sort;
    String paymentMethod;
}
