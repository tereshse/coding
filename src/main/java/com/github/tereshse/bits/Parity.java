package com.github.tereshse.bits;

public class Parity {
    private static final boolean[] PRECALCULATED_PARITYT;
    private static final int BIT_MASK = 0xFFFF;

    static {
        PRECALCULATED_PARITYT = new boolean[BIT_MASK + 1];
        for (int value = 0; value < PRECALCULATED_PARITYT.length; value++) {
            PRECALCULATED_PARITYT[value] = bruteForceParity(value);
        }
    }

    public static boolean bruteForceParity(long value) {
        boolean parity = false;
        while (value != 0) {
            if ((value & 1) != 0) {
                parity = !parity;
            }
            value >>>= 1;
        }
        return parity;
    }

    public static boolean precalculatedParity(long value) {
        boolean parity = false;
        parity ^= PRECALCULATED_PARITYT[(int) value & BIT_MASK];
        value >>>= 16;
        parity ^= PRECALCULATED_PARITYT[(int) value & BIT_MASK];
        value >>>= 16;
        parity ^= PRECALCULATED_PARITYT[(int) value & BIT_MASK];
        value >>>= 16;
        parity ^= PRECALCULATED_PARITYT[(int) value & BIT_MASK];
        return parity;
    }

    public static boolean fastParity(long value) {
        value ^= value >>> 32;
        value ^= value >>> 16;
        value ^= value >>> 8;
        value ^= value >>> 4;
        value ^= value >>> 2;
        value ^= value >>> 1;
        return (value & 1) == 1;
    }
}