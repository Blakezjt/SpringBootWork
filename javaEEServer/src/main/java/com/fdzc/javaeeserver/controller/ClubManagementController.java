package com.fdzc.javaeeserver.controller;

import com.fdzc.javaeeserver.common.R;
import com.fdzc.javaeeserver.entity.ClubManagement;
import com.fdzc.javaeeserver.service.ClubManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/club")
public class ClubManagementController {

    @Autowired
    private ClubManagementService clubManagementService;

    // 查看社团信息和公告
    @GetMapping("/getClubInfo")
    public R getClubInfo(@RequestParam Integer clubId) {
        ClubManagement clubManagement = clubManagementService.getClubInfo(clubId);
        return new R(200, "查询成功", clubManagement);
    }

    // 添加社团活动
    @PostMapping("/addClub")
    public R addClub(ClubManagement clubManagement) {
        boolean success = clubManagementService.addClub(clubManagement);
        return success ? new R(200, "添加成功" , true) : new R(500,"添加失败",false);
    }
}
