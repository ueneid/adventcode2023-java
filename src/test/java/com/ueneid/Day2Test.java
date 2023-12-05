package com.ueneid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day2Test {

    @Test
    void part1() {
        var obj = new Day2(Resource.resourceAsListOfString("input/day2/sample1.txt"));
        assertEquals(8, obj.part1());
    }

    @Test
    void part2() {
        var obj = new Day2(Resource.resourceAsListOfString("input/day2/sample1.txt"));
        assertEquals(2286, obj.part2());
    }
}
