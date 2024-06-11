package com.fdzc.javaeeserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
public interface IPaymentService extends IService<Payment> {
    //分页查询
    IPage<Payment> list(Page<Payment> page);
    //学号查询缴费记录分页
    IPage<Payment> getPaymentsByStudentId(Page<Payment> page, Integer studentId);
}
