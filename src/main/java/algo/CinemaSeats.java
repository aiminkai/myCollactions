package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeats {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        // Заполняем карту забронированных мест
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int result = 2 * (n - reserved.size()); // Ряды без брони

        var t = reserved.values();
        for (Set<Integer> seats : reserved.values()) {
            boolean left = true, middle = true, right = true;

            // Проверяем левую зону (2-5)
            for (int col = 2; col <= 5; col++) {
                if (seats.contains(col)) {
                    left = false;
                    break;
                }
            }

            // Проверяем центральную зону (4-7)
            for (int col = 4; col <= 7; col++) {
                if (seats.contains(col)) {
                    middle = false;
                    break;
                }
            }

            // Проверяем правую зону (6-9)
            for (int col = 6; col <= 9; col++) {
                if (seats.contains(col)) {
                    right = false;
                    break;
                }
            }

            // Считаем максимальное количество групп в ряду
            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CinemaSeats solution = new CinemaSeats();
        int n = 3;
//        int n = 2;
        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
//        int[][] reservedSeats = {{2,1},{1,8},{2,6}};
        System.out.println(solution.maxNumberOfFamilies(n, reservedSeats)); // Output: 4
    }
}
