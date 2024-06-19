package com.fdzc.javaeeserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fdzc.javaeeserver.entity.EventRegistration;
import com.fdzc.javaeeserver.vo.event.EventVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventRegisterMapper extends BaseMapper<EventRegistration> {
}
