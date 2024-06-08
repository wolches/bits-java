package io.github.wolches.composed_ids.entity;

import io.github.wolches.composed_ids.EmployeeId;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Short id;
    private String name;
    private Short organisationId;
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        employee.setDepartmentId(id);
        employee.setOrganisationId(organisationId);
    }

    public Short getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Short organisationId) {
        this.organisationId = organisationId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = new ArrayList<>();
        for (Employee employee : employees) {
            addEmployee(employee);
        }
    }
}
