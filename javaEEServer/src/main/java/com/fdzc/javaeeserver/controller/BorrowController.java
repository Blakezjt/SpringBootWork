package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Borrowing;
import com.fdzc.javaeeserver.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/b")
public class BorrowController {
    @Autowired
    private IBorrowService iBorrowService;

    @GetMapping
    public R query(){
        return R.success(iBorrowService.list(),"查询成功");
    }
    @GetMapping("selectById")
    public R query1(Integer resourceId){
        return R.success(iBorrowService.getById(resourceId),"查询成功");
    }
    @DeleteMapping("/delete")
    public R delete(Integer resourceId){
        return R.success(iBorrowService.removeById(resourceId),"删除成功");
    }
    @PutMapping("/add")
    public R add(Borrowing borrowing){
        return R.success(iBorrowService.save(borrowing),"添加成功");
    }



}
