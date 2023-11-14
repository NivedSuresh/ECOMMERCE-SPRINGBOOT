package com.ecommerce.library.Service;

import com.ecommerce.library.Model.User.Order;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ExcelService {
    ByteArrayInputStream getOrderAsExcel(String orderStatus, List<Order> orders);
}
