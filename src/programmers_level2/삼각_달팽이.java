package programmers_level2;

public class 삼각_달팽이 {

    // https://namhandong.tistory.com/177
    // https://wellbell.tistory.com/201
    public int[] solution(int n) {
        int max = n * (n + 1) / 2;
        int[][] matrix = new int[n][n];
        int[] answer = new int[max];

        int x = 0, y = 0;
        int value = 1;
        matrix[0][0] = 1;

        while (value < max) {
            while (x + 1 < n && matrix[x + 1][y] == 0) {
                matrix[++x][y] = ++value;
            }
            while (y + 1 < n && matrix[x][y + 1] == 0) {
                matrix[x][++y] = ++value;
            }
            while (y - 1 > 0 && x - 1 > 0 && matrix[x - 1][y - 1] == 0) {
                matrix[--x][--y] = ++value;
            }
        }

        int idx = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = matrix[i][j];
            }
        }

        return answer;
    }
}
