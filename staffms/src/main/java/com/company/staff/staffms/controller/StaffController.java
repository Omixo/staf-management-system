package com.company.staff.staffms.controller;

import com.company.staff.staffms.entity.StaffMember;
import com.company.staff.staffms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // READ all staff
    @GetMapping("/read")
    public List<StaffMember> readAll() {
        return staffService.getAllStaff();
    }

    // READ single staff by ID
    @GetMapping("/read/{id}")
    public StaffMember readOne(@PathVariable Integer id) {
        StaffMember staff = staffService.getStaff(id);
        if (staff == null) {
            throw new RuntimeException("Staff not found");
        }
        return staff;
    }

    // ADD new staff
    @PostMapping("/add")
    public StaffMember add(@RequestBody StaffMember staff) {
        return staffService.addStaff(staff);
    }

    // EDIT / UPDATE existing staff
    @PutMapping("/edit/{id}")
    public StaffMember edit(@PathVariable Integer id, @RequestBody StaffMember staff) {
        StaffMember updated = staffService.updateStaff(id, staff);
        if (updated == null) {
            throw new RuntimeException("Staff not found");
        }
        return updated;
    }

    // DELETE staff
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean deleted = staffService.deleteStaff(id);
        if (!deleted) {
            return "Staff not found";
        }
        return "Deleted successfully";
    }

    // COUNT all staff
    @GetMapping("/count")
    public int count() {
        return staffService.countStaff();
    }
}
