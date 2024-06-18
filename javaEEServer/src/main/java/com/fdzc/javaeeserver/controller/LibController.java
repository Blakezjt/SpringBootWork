package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.Lib;
import com.fdzc.javaeeserver.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/a")
public class LibController {

    @Autowired
    private LibService libService;

    @GetMapping
    public R query() {
        return R.success(libService.list());
    }

    @GetMapping("/selectById")
    public R query1(Integer bookId){
        return R.success(libService.getById(bookId),"查询成功");
    }

    @DeleteMapping("/delete")
    public R delete(Integer bookId){
        return R.success(libService.removeById(bookId),"删除成功");
    }

    @PutMapping("/add")
    public R add(Lib lib){
        return R.success(libService.save(lib),"添加成功");
    }

}
