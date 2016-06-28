package com.github.tereshse.bits;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertTest {

    @Test
    public void toBitString() throws Exception {
        assertThat(Convert.toBitString(0)).isEqualTo("0");
        assertThat(Convert.toBitString(1)).isEqualTo("1");
        assertThat(Convert.toBitString(43)).isEqualTo("101011");
        assertThat(Convert.toBitString(-43)).isEqualTo("11111111111111111111111111010101");
        assertThat(Convert.toBitString(-1)).isEqualTo("11111111111111111111111111111111");
    }
}