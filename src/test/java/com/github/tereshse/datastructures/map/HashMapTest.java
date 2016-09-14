package com.github.tereshse.datastructures.map;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

    @Test
    public void testMethod(){
        HashMap<String,String> map = new HashMap<>(1000);

        map.put("100","1");
        map.put("101","2");
        map.put("Aa","3");
        map.put("BB","4");

        assertThat(map.get("100")).isEqualTo("1");
        assertThat(map.get("101")).isEqualTo("2");
        assertThat(map.get("Aa")).isEqualTo("3");
        assertThat(map.get("BB")).isEqualTo("4");
        assertThat(map.get("102")).isNull();
    }
}