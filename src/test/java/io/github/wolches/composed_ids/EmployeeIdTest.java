package io.github.wolches.composed_ids;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeIdTest {

    @RepeatedTest(100)
    void testConversion100Times() {
        long expected = new Random().nextLong();
        long actual = new EmployeeId(expected).toLong();

        assertEquals(expected, actual, errorMessage(expected, actual));
    }

    private String errorMessage(long expected, long actual) {
        return String.format(
                "Failed conversion test: \r\n0x%s expected, \r\n0x%s actual value",
                Long.toHexString(expected).toUpperCase(), Long.toHexString(actual).toUpperCase()
        );
    }
}