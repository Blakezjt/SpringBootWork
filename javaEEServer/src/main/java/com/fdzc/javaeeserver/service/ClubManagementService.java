package com.fdzc.javaeeserver.service;

import com.fdzc.javaeeserver.entity.ClubManagement;

public interface ClubManagementService {
    ClubManagement getClubInfo(Integer clubId);

    boolean addClub(ClubManagement clubManagement);
}
