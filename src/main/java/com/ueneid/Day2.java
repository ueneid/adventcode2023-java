package com.ueneid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Day2 {
    private final List<String> input;

    enum Cube {
        RED(12, "red"), GREEN(13, "green"), BLUE(14, "blue");

        int count;
        String name;

        Cube(int count, String name) {
            this.count = count;
        }

        int getMaxLimit() {
            return switch (this) {
                case RED -> 12;
                case GREEN -> 13;
                case BLUE -> 14;
            };
        }
    }

    static class GameSet {
        public static GameSet parse(String[] sets) {
            var gameSet = new GameSet();
            for (int i = 0; i < sets.length; i++) {
                var setList = sets[i].split(" ");
                var cube = switch (setList[1]) {
                    case "red" -> Cube.RED;
                    case "green" -> Cube.GREEN;
                    case "blue" -> Cube.BLUE;
                    default -> throw new IllegalStateException("Unexpected value: " + setList[0]);
                };
                gameSet.record.put(cube, Integer.parseInt(setList[0]));
            }
            return gameSet;
        }

        Map<Cube, Integer> record = new HashMap<>();

        public boolean isPossible() {
            return this.record.entrySet().stream().allMatch(
                    cubeIntegerEntry -> cubeIntegerEntry.getKey().getMaxLimit() >= cubeIntegerEntry.getValue());
        }
    }

    static class Game {
        Integer id;
        List<GameSet> gameSetList;

        static Pattern pat = Pattern.compile("^Game (\\d+): (.+)$");

        public static Game parse(String str) {
            var m = pat.matcher(str);
            if (m.matches()) {
                var id = m.group(1);
                var gameSetList = Arrays.stream(m.group(2).split("; *")).map(
                        gameSet -> GameSet.parse(gameSet.split(", *"))).toList();
                return new Game(Integer.valueOf(id), gameSetList);
            }
            return null;
        }

        public Game(Integer id, List<GameSet> gameSetList) {
            this.id = id;
            this.gameSetList = gameSetList;
        }

        public boolean isPossibleGame() {
            return this.gameSetList.stream().allMatch(gameSet -> gameSet.isPossible());
        }
    }

    public Day2(List<String> input) {
        this.input = input;
    }

    public int part1() {
        var gameList = input.stream().map((line -> Game.parse(line))).toList();
        return gameList.stream().filter(game -> game.isPossibleGame()).mapToInt(game -> game.id).sum();
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
