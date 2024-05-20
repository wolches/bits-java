package io.github.wolches.bits;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BitsTest {

    @Test
    void testBitsArray() {
        testBits_1(BitsArray::new);
        testBits_2(BitsArray::new);
        testBits_3(BitsArray::new);
        testBits_4(BitsArray::new);
    }

    @Test
    void testBitsList() {
        testBits_1(BitsList::new);
        testBits_2(BitsList::new);
        testBits_3(BitsList::new);
        testBits_4(BitsList::new);
    }

    void testBits_1(Function<Integer, Bits> bitsFromSize) {
        Bits bits = bitsFromSize.apply(8);
        bits.setTrue(0);
        BigInteger integer = bits.toBigInteger();
        byte[] bytes = bits.toByteArray();

        assertEquals(1, bytes.length);
        assertEquals((byte) -128, bytes[0]);
        assertEquals(BigInteger.valueOf(-128), integer);
    }

    void testBits_2(Function<Integer, Bits> bitsFromSize) {
        Bits bits = bitsFromSize.apply(8);
        bits.setTrue(0);
        BigInteger integer = bits.toBigInteger();
        byte[] bytes = bits.toByteArray();

        assertEquals(1, bytes.length);
        assertEquals((byte) -128, bytes[0]);
        assertEquals(BigInteger.valueOf(-128), integer);
    }

    void testBits_3(Function<Integer, Bits> bitsFromSize) {
        Bits bits = bitsFromSize.apply(12);
        bits.setTrue(4);
        BigInteger integer = bits.toBigInteger();
        byte[] bytes = bits.toByteArray();

        assertEquals(2, bytes.length);
        assertEquals((byte) 0, bytes[0]);
        assertEquals(BigInteger.valueOf(128), integer);
    }

    void testBits_4(Function<Integer, Bits> bitsFromSize) {
        Bits bits = bitsFromSize.apply(12);
        bits.setTrue(0);
        bits.setTrue(4);
        bits.setTrue(8);
        BigInteger integer = bits.toBigInteger();
        byte[] bytes = bits.toByteArray();

        assertEquals(2, bytes.length);
        assertEquals((byte) 8, bytes[0]);
        assertEquals(BigInteger.valueOf(0x888), integer);
    }

}