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

    public int part2() {
        return input.stream()
                    .map(this::replaceWordWithNumber)
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

    private String replaceWordWithNumber(String str) {
        return str
                .replaceAll("one", "o1e")
                .replaceAll("two", "t2o")
                .replaceAll("three", "th3ee")
                .replaceAll("four", "fo4r")
                .replaceAll("five", "fi5e")
                .replaceAll("six", "s6x")
                .replaceAll("seven", "se7en")
                .replaceAll("eight", "ei8ht")
                .replaceAll("nine", "ni9e");
    }

    public static void main(String[] args) {
        var input = Resource.resourceAsListOfString("input/day1/input.txt");
        var obj = new Day1(input);
        var answer1 = obj.part1();
        System.out.println(answer1);
        var answer2 = obj.part2();
        System.out.println(answer2);
    }
}
