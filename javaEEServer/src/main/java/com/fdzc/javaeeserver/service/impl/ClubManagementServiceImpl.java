package com.fdzc.javaeeserver.service.impl;

import com.fdzc.javaeeserver.entity.ClubManagement;
import com.fdzc.javaeeserver.mapper.ClubManagementMapper;
import com.fdzc.javaeeserver.service.ClubManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubManagementServiceImpl implements ClubManagementService {

    @Autowired
    private ClubManagementMapper clubMapper;

    @Override
    public ClubManagement getClubInfo(Integer clubId) {
        return clubMapper.selectById(clubId);
    }

    @Override
    public boolean addClub(ClubManagement clubManagement) {
        int result = clubMapper.insert(clubManagement);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
