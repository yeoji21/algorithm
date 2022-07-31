package programmers_level2;

import java.util.Arrays;

public class n2_배열_자르기 {
    public static void main(String[] args) {
//        int[] solution = solution3(4, 7, 14);
        int[] solution = solution3(3, 2, 5);
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static int[] solution3(int n, long left, long right) {
        int[] result = new int[(int) (right + 1 - left)];

        int idx = 0;
        for (long i = left; i < right + 1; i++, idx++) {
            result[idx] = Math.max((int) (i / n) + 1, (int) (i % n) + 1);
        }

        return result;
    }

    public static int[] solution2(int n, long left, long right) {
        int[] array = new int[n * n];

        for (int i = 1, idx = 0; i < n + 1; i++) {
            for (int t = 0; t < i; t++) {
                array[idx++] = i;
            }

            for (int j = i + 1; j < n + 1; j++) {
                array[idx++] = j;
            }
        }

        int[] result = new int[(int) (right + 1 - left)];
        for (int i = (int) left, idx = 0; i < (int) right + 1; i++, idx++) {
            result[idx] = array[i];
        }
        return result;
    }

    public static int[] solution(int n, long left, long right) {
        int[][] map = new int[n][n];

        for (int x = 1; x < n + 1; x++) {
            map[x - 1][x - 1] = x;
            for (int i = 0; i < x; i++) {
                map[i][x - 1] = x;
                map[x - 1][i] = x;
            }
        }

        int[] array = Arrays.stream(map).flatMapToInt(Arrays::stream)
                .toArray();

        int[] result = new int[(int) (right + 1 - left)];
        for (int i = (int) left, idx = 0; i < (int) right + 1; i++, idx++) {
            result[idx] = array[i];
        }
        return result;
    }
}
