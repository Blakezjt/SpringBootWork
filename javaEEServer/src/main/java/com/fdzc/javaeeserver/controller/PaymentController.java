package com.fdzc.javaeeserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Payment;
import com.fdzc.javaeeserver.service.IPaymentService;
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
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.list();
    }

    @GetMapping("/all")
    public IPage<Payment> getAllPayments(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Payment> newsPage = new Page<>(page, size);
        return paymentService.list(newsPage);
    }

    @GetMapping("/allByStu")
    public IPage<Payment> getPaymentsByStudentId(
            @RequestParam("studentId") Integer studentId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Payment> paymentPage = new Page<>(page, size);
        return paymentService.getPaymentsByStudentId(paymentPage, studentId);
    }


    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @PostMapping
    public boolean createPayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @PutMapping
    public boolean updatePayment(@RequestBody Payment payment) {
        return paymentService.updateById(payment);
    }

    @DeleteMapping("/{id}")
    public boolean deletePayment(@PathVariable("id") Integer id) {
        return paymentService.removeById(id);
    }
}
