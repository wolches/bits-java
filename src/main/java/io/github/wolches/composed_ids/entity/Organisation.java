package io.github.wolches.composed_ids.entity;

import java.util.ArrayList;
import java.util.List;

public class Organisation {

    private Short id;
    private String name;
    private List<Department> departments;

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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = new ArrayList<>();
        for (Department department : departments) {
            addDepartment(department);
        }
    }

    public void addDepartment(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        }
        department.setOrganisationId(id);
        departments.add(department);
    }
}
