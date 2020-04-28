package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class jUnit_tests {
    @Test
    void first(){
        String str = "a";
        assertEquals("a", str);
    }
}
