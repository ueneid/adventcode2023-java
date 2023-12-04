package com.ueneid;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    private final List<String> input;

    public Day1(List<String> input) {
        this.input = input;
    }

    public int part1() {
        return input.stream()
                    .map(this::extractFirstAndLastDigit)
                    .mapToInt(Integer::valueOf)
                    .sum();
    }

    private int extractFirstAndLastDigit(String str) {
        String numbers = str.chars()
                            .filter(Character::isDigit)
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.joining());

        return Integer.parseInt("" + numbers.charAt(0) + numbers.charAt(numbers.length() - 1));
    }

    public static void main(String[] args) {
        var input = Resource.resourceAsListOfString("input/day1/input.txt");
        var answer1 = new Day1(input).part1();
        System.out.println(answer1);
    }
}
