package com.ueneid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day1Test {

    @Test
    void part1() {
        var obj = new Day1(Resource.resourceAsListOfString("input/day1/sample.txt"));
        var result = obj.part1();
        assertEquals(result, 142);
    }
}
