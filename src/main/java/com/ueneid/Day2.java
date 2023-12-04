package com.ueneid;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day2 {
    private final List<String> input;

    enum Cube {
        RED(12), GREEN(13), BLUE(14);

        final int maxLimit;

        Cube(int maxLimit) {
            this.maxLimit = maxLimit;
        }
    }

    static class GameSet {
        private final Map<Cube, Integer> cubeCounts;

        private GameSet(Map<Cube, Integer> cubeCounts) {
            this.cubeCounts = cubeCounts;
        }

        public static GameSet parse(String setString) {
            Map<Cube, Integer> cubeCounts = Arrays.stream(setString.split(", *"))
                                                  .map(s -> s.split(" +"))
                                                  .collect(Collectors.toMap(
                                                          s -> Cube.valueOf(s[1].toUpperCase()),
                                                          s -> Integer.parseInt(s[0])
                                                  ));
            return new GameSet(cubeCounts);
        }

        public boolean isPossible() {
            return cubeCounts.entrySet().stream()
                             .allMatch(e -> e.getKey().maxLimit >= e.getValue());
        }
    }

    static class Game {
        private final int id;
        private final List<GameSet> gameSetList;

        private Game(int id, List<GameSet> gameSetList) {
            this.id = id;
            this.gameSetList = gameSetList;
        }

        public static Game parse(String gameString) {
            String[] parts = gameString.split(": ", 2);
            if (parts.length < 2) {
                throw new IllegalArgumentException("Invalid game string: " + gameString);
            }
            int id = Integer.parseInt(parts[0].substring(5));
            List<GameSet> gameSetList = Arrays.stream(parts[1].split("; *"))
                                              .map(GameSet::parse)
                                              .toList();
            return new Game(id, gameSetList);
        }

        public boolean isPossibleGame() {
            return gameSetList.stream().allMatch(GameSet::isPossible);
        }

        public int getId() {
            return id;
        }
    }

    public Day2(List<String> input) {
        this.input = input;
    }

    public int part1() {
        return input.stream()
                    .map(Game::parse)
                    .filter(Game::isPossibleGame)
                    .mapToInt(Game::getId)
                    .sum();
    }

    public int part2() {
        return 1;
    }

    public static void main(String[] args) {
        var input = Resource.resourceAsListOfString("input/day2/input.txt");
        var obj = new Day2(input);
        var answer1 = obj.part1();
        System.out.println(answer1);
//        var answer2 = obj.part2();
//        System.out.println(answer2);
    }
}
