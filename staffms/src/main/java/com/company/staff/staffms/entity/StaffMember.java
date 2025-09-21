package com.company.staff.staffms.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "staff_members")
public class StaffMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_no")
    private Integer staffNo;

    @Column(name = "staff_id", length = 10, unique = true)
    private String staffId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "annual_salary")
    private BigDecimal annualSalary;

    // ✅ Default no-argument constructor (required by JPA)
    public StaffMember() {}

    // Optional: parameterized constructor for convenience
    public StaffMember(String staffId, String fullName, String managerName, String departmentName, BigDecimal annualSalary) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.managerName = managerName;
        this.departmentName = departmentName;
        this.annualSalary = annualSalary;
    }

    // Getters & setters
    public Integer getStaffNo() { return staffNo; }
    public void setStaffNo(Integer staffNo) { this.staffNo = staffNo; }

    public String getStaffId() { return staffId; }
    public void setStaffId(String staffId) { this.staffId = staffId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public BigDecimal getAnnualSalary() { return annualSalary; }
    public void setAnnualSalary(BigDecimal annualSalary) { this.annualSalary = annualSalary; }
}
