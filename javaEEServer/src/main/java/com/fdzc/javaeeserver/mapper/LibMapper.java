package com.fdzc.javaeeserver.mapper;

import com.fdzc.javaeeserver.entity.Lib;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LibMapper {

   List<Lib> getAllList();

}
