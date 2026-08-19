package com.dsa.patterns.dailyquestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {

    public static void main(String[] args) {
        CinemaSeatAllocation cinemaSeatAllocation = new CinemaSeatAllocation();
        int n = 3;
        int[][] reservedSeats = {
                {1, 2},
                {1, 3},
                {1, 8},
                {2, 6},
                {3, 1},
                {3, 10}
        };
        System.out.println(cinemaSeatAllocation.maxNumberOfFamilies(n, reservedSeats));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> rowsToSeats = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            rowsToSeats.computeIfAbsent(reservedSeat[0], seats -> new HashSet<>()).add(reservedSeat[1]);

        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!rowsToSeats.containsKey(i)) count += 2;
            else {
                Set<Integer> seats = rowsToSeats.get(i);
                boolean left = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
                boolean middle = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);
                boolean right = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);

                if (left) count++;
                if (right) count++;
                if (!left && !right && middle) count++;
            }
        }
        return count;
    }
}
