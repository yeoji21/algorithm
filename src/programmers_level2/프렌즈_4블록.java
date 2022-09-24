package programmers_level2;

public class 프렌즈_4블록 {
    private static int WIDTH, HEIGHT;
    private static final int[] dx = {0, -1, -1, 0};
    private static final int[] dy = {0, -1, 0, -1};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        WIDTH = n;
        HEIGHT = m;

        char[][] map = new char[WIDTH][HEIGHT];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while(true){
            boolean[][] checked = getRemoveBlocks(map);
            int count = remove(checked, map);
            if(count == 0) break;
            answer += count;
        }

        return answer;
    }

    private boolean[][] getRemoveBlocks(char[][] map) {
        boolean[][] checked = new boolean[WIDTH][HEIGHT];
        for (int i = 1; i < WIDTH; i++) {
            for (int j = 1; j < HEIGHT; j++) {
                char character = map[i][j];
                if(character == '.') continue;
                boolean flag = true;

                for (int d = 0; d < 4; d++) {
                    if (map[i + dx[d]][j + dy[d]] != character) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;

                for (int d = 0; d < 4; d++) {
                    checked[i + dx[d]][j + dy[d]] = true;
                }
            }
        }
        return checked;
    }

    private int remove(boolean[][] checked, char[][] map) {
        int count = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if(checked[i][j]) {
                    map[i][j] = '.';
                    count++;
                }
            }
        }

        for (int x = HEIGHT - 1; x >= 0; x--) {
            for (int y = 0; y < WIDTH; y++) {
                if(map[x][y] != '.') continue;

                int idx = x;
                while (idx > 0 && map[idx][y] == '.') idx--;

                if(map[idx][y] == '.') continue;
                map[x][y] = map[idx][y];
                map[idx][y] = '.';
            }
        }

        return count;
    }
}
