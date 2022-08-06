package programmers_level2;

public class 땅따먹기 {
    public static void main(String[] args) {
        int solution = solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        System.out.println(solution);
    }

    static int solution(int[][] land) {
        int result = 0;

        int lastColumn = -1;
        int first = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i == j) continue;
                if(land[0][i] + land[1][j] > first) {
                    first = land[0][i] + land[1][j];
                    lastColumn = j;
                }
            }
        }
        result += first;

        for (int i = 1; i < land.length - 1; i++) {
            int max = 0;
            for (int x = 0; x < 4; x++) {
                if(x != lastColumn) continue;
                for (int y = 0; y < 4; y++) {
                    if(x == y) continue;
                    if(land[i][x] + land[i + 1][y] > max) {
                        max = land[i][x] + land[i + 1][y];
                        lastColumn = y;
                    }
                }
            }
            result += land[i+1][lastColumn];
        }

        return result;
    }
}
