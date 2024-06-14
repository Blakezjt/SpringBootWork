package com.fdzc.javaeeserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface PaymentMapper extends BaseMapper<Payment> {
    @Select("SELECT * FROM payment")
    IPage<Payment> selectPaymentPage(Page<?> page);

    @Select("SELECT * FROM payment WHERE student_id = #{studentId}")
    IPage<Payment> selectPaymentByStu(Page<?> page, @Param("studentId") Integer studentId);
}
