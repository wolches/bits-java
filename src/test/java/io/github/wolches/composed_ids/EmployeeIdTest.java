package io.github.wolches.composed_ids;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeIdTest {

    @RepeatedTest(100)
    void testConversion_ComposedIdValue() {
        long expected = new Random().nextLong();
        long actual = new EmployeeId(expected).toLong();

        assertEquals(expected, actual, errorMessage(expected, actual));

        System.out.println(successMessage(expected, actual));
    }

    @RepeatedTest(100)
    void testConversion_ComposedIdFields() {
        Random random = new Random();
        short orgId = (short) random.nextInt();
        short depId = (short) random.nextInt();
        int empId = random.nextInt();

        EmployeeId expected = new EmployeeId(orgId, depId, empId);
        EmployeeId actual = new EmployeeId(expected.toLong());

        assertEquals(expected.getOrganisationId(), actual.getOrganisationId(), errorMessage(expected, actual));
        assertEquals(expected.getDepartmentId(), actual.getDepartmentId(), errorMessage(expected, actual));
        assertEquals(expected.getEmployeeSelfId(), actual.getEmployeeSelfId(), errorMessage(expected, actual));

        System.out.println(successMessage(expected, actual));
    }

    private String successMessage(EmployeeId expected, EmployeeId actual) {
        return String.format(
                "Successful conversion test: \r\n(%d, %d, %d) - expected, \r\n(%d, %d, %d) - actual value",
                expected.getOrganisationId(), expected.getDepartmentId(), expected.getEmployeeSelfId(),
                actual.getOrganisationId(), actual.getDepartmentId(), actual.getEmployeeSelfId());
    }

    private String errorMessage(EmployeeId expected, EmployeeId actual) {
        return String.format(
                "Failed conversion test: \r\n(%d, %d, %d) - expected, \r\n(%d, %d, %d) - actual value",
                expected.getOrganisationId(), expected.getDepartmentId(), expected.getEmployeeSelfId(),
                actual.getOrganisationId(), actual.getDepartmentId(), actual.getEmployeeSelfId());
    }

    private String errorMessage(long expected, long actual) {
        return String.format(
                "Failed conversion test: \r\n0x%s - expected, \r\n0x%s - actual value",
                Long.toHexString(expected).toUpperCase(), Long.toHexString(actual).toUpperCase()
        );
    }

    private String successMessage(long expected, long actual) {
        return String.format(
                "Successful conversion test: \r\n0x%s - expected, \r\n0x%s - actual value \r\n%d\r\n%d",
                Long.toHexString(expected).toUpperCase(), Long.toHexString(actual).toUpperCase(), expected, actual
        );
    }
}