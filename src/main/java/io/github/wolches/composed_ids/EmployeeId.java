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
        this.organisationId = (short) ((composedId & 0xFFFF_0000_0000_0000L) >>> 48);
        this.departmentId = (short) ((composedId & 0x0000_FFFF_0000_0000L) >>> 32);
        this.employeeSelfId = (int) (composedId & 0x0000_0000_FFFF_FFFFL);
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
        return ((((long) organisationId) << 48) & 0xFFFF_0000_0000_0000L)
                | ((((long) departmentId) << 32) & 0x0000_FFFF_0000_0000L)
                | (((long) employeeSelfId) & 0x0000_0000_FFFF_FFFFL);
    }
}
