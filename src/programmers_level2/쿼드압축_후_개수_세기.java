package programmers_level2;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {
    public static void main(String[] args) {
        int[] solution = solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        Arrays.stream(solution).forEach(System.out::println);
    }

    static int[] result = new int[2];

    public static int[] solution(int[][] arr) {
        recursive(0,0, arr, arr.length);
        return result;
    }

    private static void recursive(int startX, int startY, int[][] arr, int n) {
        if (check(startX, startY, arr, n)) {
            result[arr[startX][startY]]++;
            return;
        }

        recursive(startX, startY, arr, n / 2);
        recursive(startX, startY + n / 2, arr, n / 2);
        recursive(startX + n / 2, startY, arr, n / 2);
        recursive(startX + n / 2, startY + n / 2, arr, n / 2);
    }


    private static boolean check(int x, int y, int[][] arr, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}
