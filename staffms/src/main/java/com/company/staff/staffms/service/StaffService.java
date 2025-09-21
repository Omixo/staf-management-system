package com.company.staff.staffms.service;

import com.company.staff.staffms.entity.StaffMember;

import java.util.List;

public interface StaffService {

    List<StaffMember> getAllStaff();

    StaffMember getStaff(Integer id);

    StaffMember addStaff(StaffMember staff);

    StaffMember updateStaff(Integer id, StaffMember staff);

    boolean deleteStaff(Integer id);

    int countStaff();
}
