package programmers_level2;

public class 행렬_테두리_회전하기 {
    public int[] solution2(int rows, int columns, int[][] queries) {
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


    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];

        for (int i = 1, value = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++, value++) {
                map[i][j] = value;
            }
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int min = Integer.MAX_VALUE;

            int startX = query[0];
            int startY = query[1];
            int endX = query[2];
            int endY = query[3];

            int temp = map[startX][startY];
            int idx = 0;

            int currentX = startX;
            int currentY = startY;

            while (idx < 4) {
                int nextX = currentX + dx[idx];
                int nextY = currentY + dy[idx];

                if (nextX < startX || nextX > endX || nextY < startY || nextY > endY){
                    idx++;
                    continue;
                }
                map[currentX][currentY] = map[nextX][nextY];
                min = Math.min(min, map[currentX][currentY]);
                currentX = nextX;
                currentY = nextY;
            }
            map[currentX][currentY + 1] = temp;
            min = Math.min(min, map[currentX][currentY + 1]);

            result[i] = min;
        }

        return result;
    }
}
