package com.fdzc.javaeeserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fdzc.javaeeserver.entity.Borrowing;
import com.fdzc.javaeeserver.mapper.BorrowingMapper;
import com.fdzc.javaeeserver.service.IBorrowService;
import org.springframework.stereotype.Service;

@Service
public class BorrowingImpl extends ServiceImpl<BorrowingMapper, Borrowing> implements IBorrowService {

}
