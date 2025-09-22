package com.company.staff.staffms.repository;

import com.company.staff.staffms.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<StaffMember, Long> {

    // Custom search methods
    List<StaffMember> findByDepartmentNameContainingIgnoreCase(String departmentName);

    List<StaffMember> findByManagerNameContainingIgnoreCase(String managerName);

    // DON'T override findById with StaffMember return type!
}
