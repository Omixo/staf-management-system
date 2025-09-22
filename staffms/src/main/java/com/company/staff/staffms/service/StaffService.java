package com.company.staff.staffms.service;

import com.company.staff.staffms.entity.StaffMember;

import java.util.List;

public interface StaffService {

    List<StaffMember> getAllStaff();

    StaffMember getStaff(Long id);

    StaffMember addStaff(StaffMember staff);

    StaffMember updateStaff(Long id, StaffMember staff);

    boolean deleteStaff(Long id);

    int countStaff();

    List<StaffMember> searchStaff(String dept, String manager, Long staffId);

}
