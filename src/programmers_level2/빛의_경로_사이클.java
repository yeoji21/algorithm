package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};
    private int X, Y;
    private boolean[][][] matrix;
    public int[] solution(String[] grid) {
        X = grid.length;
        Y = grid[0].length();
        matrix = new boolean[X][Y][4];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!matrix[i][j][d]) {
                        answer.add(shootLight(grid, i, j, d));
                    }
                }
            }
        }

        return answer.stream()
                .mapToInt(x -> x)
                .sorted()
                .toArray();
    }

    private int shootLight(String[] grid, int x, int y, int d) {
        int count = 0;
        while (!matrix[x][y][d]) {
            matrix[x][y][d] = true;
            count++;
            char direction = grid[x].charAt(y);
            if(direction == 'L')
                d = (d + 3) % 4;
            else if (direction == 'R')
                d = (d + 1) % 4;

            x = (x + dx[d] + X) % X;
            y = (y + dy[d] + Y) % Y;
        }

        return count;
    }
}
