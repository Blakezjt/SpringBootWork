package com.fdzc.javaeeserver.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fdzc.javaeeserver.entity.Logistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fdzc.javaeeserver.entity.Payment;
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
public interface LogisticsMapper extends BaseMapper<Logistics> {
    @Select("SELECT * FROM logistics")
    IPage<Logistics> selectLogisticsPage(Page<?> page);

    @Select("SELECT * FROM logistics WHERE status = #{status}")
    IPage<Logistics> selectLogisticsByStatus(Page<?> page, @Param("status") String status);
}
