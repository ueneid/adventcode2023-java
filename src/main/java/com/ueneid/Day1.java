package com.ueneid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Day1 {
    private final List<String> input;

    public Day1(List<String> input) {
        this.input = input;
    }

    public int part1() {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            ArrayList<Character> tmp = new ArrayList<>();
            for (var code : input.get(i).toCharArray()) {
                if (Character.isDigit(code)) {
                    tmp.add(code);
                }
            }
            values.add(Integer.parseInt(tmp.getFirst().toString() + tmp.getLast().toString()));
        }
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        var input = Resource.resourceAsListOfString("input/day1/sample.txt");
        var answer1 = new Day1(input).part1();
    }
}
