package com.ecommerce.library.Service;

import com.ecommerce.library.Dtos.StatisticsDto;
import com.ecommerce.library.Model.User.Order;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public interface PdfService {
    ByteArrayInputStream createInvoiceForCustomer(Order order);

    public ByteArrayInputStream getSalesReport(Double amountFromDeliveredOrdersPastReturn,
                                               StatisticsDto statisticsDto, Double revenue);
}
