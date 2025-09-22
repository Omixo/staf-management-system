package com.company.staff.staffms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_members")
public class StaffMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_no")   // 👈 maps to DB primary key
    private Long staffNo;

    @Column(name = "staff_id")
    private String staffId;   // maps unique varchar(10)

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "annual_salary")
    private Double annualSalary;

    @Column(name = "salary", nullable = true)
    private Double salary;   // optional: map if you need this column too

    // Getters and Setters
    public Long getStaffNo() {
        return staffNo;
    }
    public void setStaffNo(Long staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }
    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
