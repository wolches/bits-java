package io.github.wolches.composed_ids;

import io.github.wolches.composed_ids.entity.Employee;

public class EmployeeId {

    private final short organisationId;
    private final short departmentId;
    private final int employeeSelfId;

    public EmployeeId(short organisationId, short departmentId, int employeeSelfId) {
        this.organisationId = organisationId;
        this.departmentId = departmentId;
        this.employeeSelfId = employeeSelfId;
    }

    public EmployeeId(long composedId) {
        this.organisationId = (short) (composedId >> 48);
        this.departmentId = (short) ((composedId >> 32) & 0x0000ffff);
        this.employeeSelfId = (int) composedId;
    }

    public EmployeeId(Employee employee) {
        this(employee.getEmployeeId());
    }

    public short getOrganisationId() {
        return organisationId;
    }

    public short getDepartmentId() {
        return departmentId;
    }

    public int getEmployeeSelfId() {
        return employeeSelfId;
    }

    public long toLong() {
        return (((long) organisationId) << 48)
                + (((long) departmentId) << 32)
                + ((long) employeeSelfId);
    }
}
