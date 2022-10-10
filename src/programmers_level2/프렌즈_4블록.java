package programmers_level2;

public class 프렌즈_4블록 {
    private int[] dx = {0, 1, 1, 0};
    private int[] dy = {1, 0, 1, 0};
    private int HEIGHT, WIDTH;
    public int solution(int m, int n, String[] board) {
        HEIGHT = m;
        WIDTH = n;
        int answer = 0;
        char[][] matrix = new char[HEIGHT][WIDTH];
        for (int i = 0; i < board.length; i++) {
            matrix[i] = board[i].toCharArray();
        }

        while(true) {
            boolean[][] checked = check(matrix);
            int count = remove(matrix, checked);
            if(count == 0) break;
            answer += count;
        }

        return answer;
    }

    private int remove(char[][] matrix, boolean[][] checked) {
        int count = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if(!checked[i][j]) continue;
                count++;
                matrix[i][j] = '.';
            }
        }
        if(count == 0) return 0;

        for (int i = 0; i < WIDTH; i++) {
            for (int j = HEIGHT - 1; j >= 0; j--) {
                if(matrix[j][i] != '.') continue;
                int idx = j;
                while(idx > 0 && matrix[idx][i] == '.') idx--;
                if(matrix[idx][i] == '.') continue;
                matrix[j][i] = matrix[idx][i];
                matrix[idx][i] = '.';
            }
        }
        return count;
    }

    private boolean[][] check(char[][] matrix) {
        boolean[][] checked = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT - 1; i++) {
            for (int j = 0; j < WIDTH - 1; j++) {
                char target = matrix[i][j];
                if(target == '.') continue;
                boolean flag = true;
                for (int d = 0; d < 4; d++) {
                    if(matrix[i + dx[d]][j + dy[d]] != target) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;
                for (int d = 0; d < 4; d++) {
                    checked[i + dx[d]][j + dy[d]] = true;
                }
            }
        }
        return checked;
    }
}
