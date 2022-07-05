package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 빛의_경로_사이클 {
    static int X, Y;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] checked;


    public int[] solution(String[] grid) {
        List<Integer> result = new ArrayList<>();
        X = grid.length;
        Y = grid[0].length();

        checked = new boolean[X][Y][4];
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!checked[i][j][d]) {
                        result.add(light(grid, i, j, d));
                    }
                }
            }
        }

        return result.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int light(String[] grid, int x, int y, int d) {
        int count = 0;

        while (true) {
            if(checked[x][y][d]) break;
            count++;
            checked[x][y][d] = true;

            if(grid[x].charAt(y) == 'L')
                d = d == 3 ? 0 : d + 1;
            if(grid[x].charAt(y) == 'R')
                d = d == 0 ? 3 : d - 1;

            x = (x + dx[d] + X) % X;
            y = (y + dy[d] + Y) % Y;
        }

        return count;
    }
}
