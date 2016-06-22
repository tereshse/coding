package com.github.tereshse.bits;

public final class Convert {
    /**
     * Converts given int value to bit string representation.
     *
     * @param value an integer
     * @return bit string representation
     */
    public static String toBitString(int value) {
        char[] chars = new char[32];
        int i = chars.length - 1;
        do {
            chars[i--] = ((value & 1) == 1) ? '1' : '0';
            value = value >>> 1;
        } while (value != 0);
        return new String(chars, i + 1, chars.length - 1 - i);
    }
}
