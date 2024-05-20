package io.github.wolches.bits;

import java.math.BigInteger;

public interface Bits {

    byte[] toByteArray();
    BigInteger toBigInteger();
    void set(int pos, boolean value);
    boolean get(int pos);
    int size();

    /**
     * @return bitstring, e.g. "01010010"
     */
    String toString();

    default void setTrue(int pos) {
        set(pos, true);
    }

    default void setFalse(int pos) {
        set(pos, false);
    }
}
