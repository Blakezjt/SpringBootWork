package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Payment;
import com.fdzc.javaeeserver.mapper.PaymentMapper;
import com.fdzc.javaeeserver.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public IPage<Payment> list(Page<Payment> page) {
        return paymentMapper.selectPaymentPage(page);
    }

    @Override
    public IPage<Payment> getPaymentsByStudentId(Page<Payment> page, Integer studentId) {
        return paymentMapper.selectPaymentByStu(page, studentId);
    }
}
