package com.ueneid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day1Test {
    @Test
    void part1() {
        var obj = new Day1(Resource.resourceAsListOfString("input/day1/sample1.txt"));
        var result = obj.part1();
        assertEquals(142, result);
    }

    @Test
    void part2() {
        var obj = new Day1(Resource.resourceAsListOfString("input/day1/sample2.txt"));
        var result = obj.part2();
        assertEquals(281, result);
    }
}
