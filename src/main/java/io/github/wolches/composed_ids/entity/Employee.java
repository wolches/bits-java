package io.github.wolches.composed_ids.entity;

import io.github.wolches.composed_ids.EmployeeId;

public class Employee {

    private Integer id;
    private String name;
    private Short organisationId;
    private Short departmentId;
    private Long employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
        refreshEmployeeId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getOrganisationId() {
        return organisationId;
    }

    protected void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setOrganisationId(Short organisationId) {
        this.organisationId = organisationId;
        refreshEmployeeId();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    private void refreshEmployeeId() {
        if (id != null) {
            employeeId = new EmployeeId(organisationId, departmentId, id).toLong();
        }
    }
}
