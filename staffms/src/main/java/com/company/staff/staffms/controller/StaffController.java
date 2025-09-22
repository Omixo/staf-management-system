package com.company.staff.staffms.controller;

import com.company.staff.staffms.entity.StaffMember;
import com.company.staff.staffms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/read")
    public List<StaffMember> readAll() {
        return staffService.getAllStaff();
    }

   @GetMapping("/api/staff/read")
public ResponseEntity<List<StaffMember>> getStaff() {
    try {
        return ResponseEntity.ok(staffService.getAllStaff());
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(null);
    }
}


    @PostMapping("/add")
    public StaffMember add(@RequestBody StaffMember staff) {
        return staffService.addStaff(staff);
    }

    @PutMapping("/edit/{id}")
    public StaffMember edit(@PathVariable Long id, @RequestBody StaffMember staff) {
        StaffMember updated = staffService.updateStaff(id, staff);
        if (updated == null) throw new RuntimeException("Staff not found");
        return updated;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return staffService.deleteStaff(id) ? "Deleted successfully" : "Staff not found";
    }

    @GetMapping("/count")
    public int count() {
        return staffService.countStaff();
    }

    @GetMapping("/search")
    public List<StaffMember> search(
            @RequestParam(required = false) String dept,
            @RequestParam(required = false) String manager,
            @RequestParam(required = false) Long staffId
    ) {
        return staffService.searchStaff(dept, manager, staffId);
    }
}
