package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.Lib;
import com.fdzc.javaeeserver.mapper.LibMapper;
import com.fdzc.javaeeserver.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LibServiceImpl implements LibService {

    @Autowired
    private LibMapper libMapper;

    @Override
    public List<Lib> getAllList() {
        return libMapper.getAllList();
    }
}
