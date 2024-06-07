package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Financialrecord;
import com.fdzc.javaeeserver.entity.Payment;
import com.fdzc.javaeeserver.mapper.FinancialrecordMapper;
import com.fdzc.javaeeserver.mapper.PaymentMapper;
import com.fdzc.javaeeserver.service.IFinancialrecordService;
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
public class FinancialrecordServiceImpl extends ServiceImpl<FinancialrecordMapper, Financialrecord> implements IFinancialrecordService {
    @Autowired
    private FinancialrecordMapper financialrecordMapper;

    @Override
    public IPage<Financialrecord> list(Page<Financialrecord> page) {
        return financialrecordMapper.selectFinancialPage(page);
    }

    @Override
    public IPage<Financialrecord> getFinancialByStudentId(Page<Financialrecord> page, Integer studentId) {
        return financialrecordMapper.selectFinancialByStu(page,studentId);
    }

    @Override
    public IPage<Financialrecord> getFinancialByType(Page<Financialrecord> page, String transactionType) {
        return financialrecordMapper.selectFinancialByType(page, transactionType);
    }
}
