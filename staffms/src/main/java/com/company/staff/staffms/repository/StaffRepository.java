package com.company.staff.staffms.repository;

import com.company.staff.staffms.entity.*;

import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface StaffRepository extends JpaRepository<StaffMember, Integer> {
    Optional<StaffMember> findByStaffId(String staffId);
    List<StaffMember> findByDepartmentName(String departmentName);
    List<StaffMember> findByManagerName(String managerName);    
    List<StaffMember> findByAnnualSalary(Double annualSalary);
    
}