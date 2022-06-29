package programmers_level2;

public class 행렬_테두리_확인하기 {
    public static void main(String[] args) {
        solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
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
