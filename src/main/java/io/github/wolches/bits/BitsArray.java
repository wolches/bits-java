package io.github.wolches.bits;

import java.math.BigInteger;
import java.util.Arrays;

public class BitsArray implements Bits {

    private final boolean[] bits;

    public BitsArray(int size) {
        this.bits = new boolean[size];
        for (int i = 0; i < size; i++) {
            bits[i] = false;
        }
    }

    public BitsArray(String string) {
        this(string.length());
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (symbol != '1' && symbol != '0') {
                throw new IllegalArgumentException("Not a bits string: " + string);
            }
            bits[i] = symbol == '1';
        }
    }

    @Override
    public byte[] toByteArray() {
        return toBigInteger().toByteArray();
    }

    @Override
    public void set(int pos, boolean value) {
        bits[pos] = value;
    }

    @Override
    public boolean get(int pos) {
        return bits[pos];
    }

    @Override
    public BigInteger toBigInteger() {
        BigInteger result = BigInteger.valueOf(0);
        int i = 0;
        while (i < bits.length - 1) {
            result = (bits[i] ? result.add(BigInteger.ONE) : result).shiftLeft(1);
            i++;
        }
        result = (bits[i] ? result.add(BigInteger.ONE) : result);
        result = checkIsLeadingOne(result);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        for (Boolean bit : bits) {
            stringBuffer.append(bit ? '1' : '0');
        }
        return stringBuffer.toString();
    }

    @Override
    public int size() {
        return bits.length;
    }

    private BigInteger checkIsLeadingOne(BigInteger result) {
        if (bits.length % 8 == 0 && bits[0] && result.compareTo(BigInteger.ZERO) > 0) {
            byte[] bytes = result.toByteArray();
            result = new BigInteger(Arrays.copyOfRange(bytes, 1, bytes.length));
        }
        return result;
    }
}
