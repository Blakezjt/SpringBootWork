package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.entity.Lib;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibService {

List<Lib> getAllList();

}
