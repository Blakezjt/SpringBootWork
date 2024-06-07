package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Logistics;
import com.fdzc.javaeeserver.entity.Payment;
import com.fdzc.javaeeserver.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
@RestController
@RequestMapping("/logistics")
public class LogisticsController {
    @Autowired
    private ILogisticsService logisticsService;

    @GetMapping
    public List<Logistics> getAllLogistics() {
        return logisticsService.list();
    }

    @GetMapping("/all")
    public IPage<Logistics> getAllLogistics(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Logistics> newsPage = new Page<>(page, size);
        return logisticsService.list(newsPage);
    }

    @GetMapping("/allByStatus")
    public IPage<Logistics> getLogisticsByStatus(
            @RequestParam("status") String status,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Logistics> paymentPage = new Page<>(page, size);
        return logisticsService.getLogisticsByStatus(paymentPage, status);
    }

    @GetMapping("/{id}")
    public Logistics getLogisticsById(@PathVariable("id") Integer id) {
        return logisticsService.getById(id);
    }

    @PostMapping
    public boolean createLogistics(@RequestBody Logistics logistics) {
        return logisticsService.save(logistics);
    }

    @PutMapping
    public boolean updateLogistics(@RequestBody Logistics logistics) {
        return logisticsService.updateById(logistics);
    }

    @DeleteMapping("/{id}")
    public boolean deleteLogistics(@PathVariable("id") Integer id) {
        return logisticsService.removeById(id);
    }
}
