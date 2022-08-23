public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] matrix, int[] query) {

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i] - 1;
        }

        int temp = matrix[query[0]][query[1]];
        int min = temp;

        for (int i = query[0]; i < query[2]; i++) {
            matrix[i][query[1]] = matrix[i + 1][query[1]];
            min = Math.min(min, matrix[i][query[1]]);
        }

        for (int i = query[1]; i < query[3]; i++) {
            matrix[query[2]][i] = matrix[query[2]][i + 1];
            min = Math.min(min, matrix[query[2]][i]);
        }

        for (int i = query[2]; i > query[0]; i--) {
            matrix[i][query[3]] = matrix[i - 1][query[3]];
            min = Math.min(min, matrix[i][query[3]]);
        }

        for (int i = query[3]; i > query[1] + 1; i--) {
            matrix[query[0]][i] = matrix[query[0]][i - 1];
            min = Math.min(min, matrix[query[0]][i]);
        }

        matrix[query[0]][query[1] + 1] = temp;

        return min;
    }
}
