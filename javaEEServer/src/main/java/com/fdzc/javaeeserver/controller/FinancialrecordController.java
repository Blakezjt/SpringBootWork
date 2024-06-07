package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Financialrecord;
import com.fdzc.javaeeserver.service.IFinancialrecordService;
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
@RequestMapping("/financialrecord")
public class FinancialrecordController {
    @Autowired
    private IFinancialrecordService financialrecordService;

    @GetMapping
    public List<Financialrecord> getAllFinancialrecords() {
        return financialrecordService.list();
    }

    @GetMapping("/all")
    public IPage<Financialrecord> getAllFinancialrecords(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Financialrecord> newsPage = new Page<>(page, size);
        return financialrecordService.list(newsPage);
    }

    @GetMapping("/allByStu")
    public IPage<Financialrecord> getFinancialByStudentId(
            @RequestParam("studentId") Integer studentId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Financialrecord> paymentPage = new Page<>(page, size);
        return financialrecordService.getFinancialByStudentId(paymentPage, studentId);
    }

    @GetMapping("/allByType")
    public IPage<Financialrecord> getFinancialByType(
            @RequestParam("transactionType") String transactionType,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Financialrecord> paymentPage = new Page<>(page, size);
        return financialrecordService.getFinancialByType(paymentPage, transactionType);
    }


    @GetMapping("/{id}")
    public Financialrecord getFinancialrecordById(@PathVariable("id") Integer id) {
        return financialrecordService.getById(id);
    }

    @PostMapping
    public boolean createFinancialrecord(@RequestBody Financialrecord financialrecord) {
        return financialrecordService.save(financialrecord);
    }

    @PutMapping
    public boolean updateFinancialrecord(@RequestBody Financialrecord financialrecord) {
        return financialrecordService.updateById(financialrecord);
    }

    @DeleteMapping("/{id}")
    public boolean deleteFinancialrecord(@PathVariable("id") Integer id) {
        return financialrecordService.removeById(id);
    }
}
