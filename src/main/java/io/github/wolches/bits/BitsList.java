package io.github.wolches.bits;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class BitsList implements Bits {

    private final ArrayList<Boolean> bits;

    public BitsList(int size) {
        this.bits = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            bits.add(false);
        }
    }

    public BitsList(String string) {
        this(string.length());
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (symbol != '1' && symbol != '0') {
                throw new IllegalArgumentException("Not a bits string: " + string);
            }
            bits.set(i, symbol == '1');
        }
    }

    @Override
    public byte[] toByteArray() {
        return toBigInteger().toByteArray();
    }

    @Override
    public void set(int pos, boolean value) {
        bits.set(pos, value);
    }

    @Override
    public boolean get(int pos) {
        return bits.get(pos);
    }

    @Override
    public BigInteger toBigInteger() {
        BigInteger result = BigInteger.valueOf(0);
        int i = 0;
        while (i < bits.size() - 1) {
            result = (bits.get(i) ? result.add(BigInteger.ONE) : result).shiftLeft(1);
            i++;
        }
        result = (bits.get(i) ? result.add(BigInteger.ONE) : result);
        result = checkIsLeadingOne(result);
        return result;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Boolean bit : bits) {
            stringBuffer.append(bit ? 1 : 0);
        }
        return stringBuffer.toString();
    }

    @Override
    public int size() {
        return bits.size();
    }

    private BigInteger checkIsLeadingOne(BigInteger result) {
        if (bits.size() % 8 == 0 && bits.get(0) && result.compareTo(BigInteger.ZERO) > 0) {
            byte[] bytes = result.toByteArray();
            result = new BigInteger(Arrays.copyOfRange(bytes, 1, bytes.length));
        }
        return result;
    }
}
