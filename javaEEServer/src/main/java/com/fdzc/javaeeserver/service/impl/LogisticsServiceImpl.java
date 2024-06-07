package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Logistics;
import com.fdzc.javaeeserver.entity.Payment;
import com.fdzc.javaeeserver.mapper.LogisticsMapper;
import com.fdzc.javaeeserver.mapper.PaymentMapper;
import com.fdzc.javaeeserver.service.ILogisticsService;
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
public class LogisticsServiceImpl extends ServiceImpl<LogisticsMapper, Logistics> implements ILogisticsService {
    @Autowired
    private LogisticsMapper logisticsMapper;

    @Override
    public IPage<Logistics> list(Page<Logistics> page) {
        return logisticsMapper.selectLogisticsPage(page);
    }

    @Override
    public IPage<Logistics> getLogisticsByStatus(Page<Logistics> page, String status) {
        return logisticsMapper.selectLogisticsByStatus(page, status);
    }
}
