package com.fdzc.javaeeserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fdzc.javaeeserver.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
