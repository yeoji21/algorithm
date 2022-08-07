package programmers_level2;

import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        System.out.println(solution);
    }

    static int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][3], Math.max(land[i - 1][1], land[i - 1][2]));
            land[i][1] += Math.max(land[i - 1][3], Math.max(land[i - 1][0], land[i - 1][2]));
            land[i][2] += Math.max(land[i - 1][3], Math.max(land[i - 1][1], land[i - 1][0]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
