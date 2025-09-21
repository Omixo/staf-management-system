package com.company.staff.staffms.service;

import com.company.staff.staffms.entity.StaffMember;
import com.company.staff.staffms.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public StaffMember getStaff(Integer id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public StaffMember addStaff(StaffMember staff) {
        return staffRepository.save(staff);
    }

    @Override
    public StaffMember updateStaff(Integer id, StaffMember staff) {
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
    public boolean deleteStaff(Integer id) {
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
}
