package com.company.staff.staffms.service;

import com.company.staff.staffms.entity.StaffMember;
import com.company.staff.staffms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffMember> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public StaffMember getStaff(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public StaffMember addStaff(StaffMember staff) {
        return staffRepository.save(staff);
    }

    @Override
    public StaffMember updateStaff(Long id, StaffMember staff) {
        Optional<StaffMember> existing = staffRepository.findById(id);
        if (existing.isPresent()) {
            StaffMember updated = existing.get();
            updated.setFullName(staff.getFullName());
            updated.setManagerName(staff.getManagerName());
            updated.setDepartmentName(staff.getDepartmentName());
            updated.setAnnualSalary(staff.getAnnualSalary());
            return staffRepository.save(updated);
        }
        return null;
    }

    @Override
    public boolean deleteStaff(Long id) {
        Optional<StaffMember> existing = staffRepository.findById(id);
        if (existing.isPresent()) {
            staffRepository.delete(existing.get());
            return true;
        }
        return false;
    }

    @Override
    public int countStaff() {
        return (int) staffRepository.count();
    }

    @Override
    public List<StaffMember> searchStaff(String dept, String manager, Long staffId) {
        List<StaffMember> result = new ArrayList<>();

        if (dept != null && !dept.isEmpty()) {
            result.addAll(staffRepository.findByDepartmentNameContainingIgnoreCase(dept));
        }
        if (manager != null && !manager.isEmpty()) {
            result.addAll(staffRepository.findByManagerNameContainingIgnoreCase(manager));
        }
        if (staffId != null) {
            staffRepository.findById(staffId).ifPresent(result::add);
        }

        return result;
    }
}
