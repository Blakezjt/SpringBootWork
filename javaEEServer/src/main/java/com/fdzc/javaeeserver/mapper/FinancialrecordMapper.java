package com.fdzc.javaeeserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Financialrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fdzc.javaeeserver.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 何安琪
 * @since 2024-06-07
 */
@Mapper
public interface FinancialrecordMapper extends BaseMapper<Financialrecord> {
    @Select("SELECT * FROM financialrecord")
    IPage<Financialrecord> selectFinancialPage(Page<?> page);

    @Select("SELECT * FROM financialrecord where student_id=#{studentId}")
    IPage<Financialrecord> selectFinancialByStu(Page<?> page, @Param("studentId") Integer studentId);

    @Select("SELECT * FROM financialrecord where transaction_type=#{transactionType}")
    IPage<Financialrecord> selectFinancialByType(Page<?> page, @Param("transactionType") String transactionType);
}
