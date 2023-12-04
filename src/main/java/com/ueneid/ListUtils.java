package com.ueneid;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T1, T2> {
    public static <T> Pair<T, T> toPair(List<T> list) {
        if (list.size() != 2) {
            throw new IllegalArgumentException("List size must be 2!");
        }
        return new Pair<T, T>(list.get(0), list.get(1));
    }

    public static <T> List<List<T>> transpose(List<List<T>> lists) {
        List<List<T>> result = new ArrayList<>();
        if (lists.isEmpty() || lists.get(0).isEmpty()) {
            return result;
        }
        int size = lists.get(0).size();
        for (int index = 0; index < size; index++) {
            List<T> col = new ArrayList<>();
            for (List<T> row : lists) {
                col.add(row.get(index));
            }
            result.add(col);
        }
        return result;
    }

    public static class Pair<T1, T2> {
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }
    }
}
