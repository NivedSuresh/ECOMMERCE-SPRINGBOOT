package com.ecommerce.admin.Controller;

import com.ecommerce.library.Service.ExcelService;
import com.ecommerce.library.Service.PdfService;
import com.ecommerce.library.ProductsService.OrderService;
import com.ecommerce.library.ProductsService.StatisticsService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DownloadController {

    ExcelService excelService;
    OrderService orderService;
    PdfService pdfService;
    StatisticsService statisticsService;

    public DownloadController(OrderService orderService,
                              PdfService pdfService, StatisticsService statisticsService,
                              ExcelService excelService) {
        this.orderService = orderService;
        this.statisticsService = statisticsService;
        this.pdfService = pdfService;
        this.excelService = excelService;
    }

    @GetMapping("/sales_report")
    public ResponseEntity<InputStreamResource> downloadSalesReport(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;file = lcwd.pdf");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(
                        pdfService.getSalesReport(orderService.findAmountFromDeliveredOrdersPastReturn(),
                        statisticsService.getAllStatistics(), statisticsService.getRevenue()))
                );
    }

    @GetMapping("/order_summary")
    public ResponseEntity<InputStreamResource> downloadOrderSummary(String orderStatus){
        return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = "+orderStatus+"-Orders.xlsx")
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
        .body(new InputStreamResource(excelService.getOrderAsExcel(orderStatus,
                                        orderService.findOrdersByStatus(orderStatus)))
        );
    }

}
