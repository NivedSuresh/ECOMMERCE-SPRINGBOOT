package com.ecommerce.admin.Controller;

import com.ecommerce.library.Dtos.StatisticsDto;
import com.ecommerce.library.ProductsService.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/admin/statistics")
    public String getStatistics(Model model){
        StatisticsDto statisticsDto = statisticsService.getAllStatistics();
        model.addAttribute("statistics", statisticsDto);
        return "/PostAuth/statistics";
    }

}
