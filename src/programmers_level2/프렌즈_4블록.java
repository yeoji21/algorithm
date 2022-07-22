package programmers_level2;

public class 프렌즈_4블록 {
    public static void main(String[] args) {
        int solution = solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(solution);
    }

    static char[][] map;
    public static int solution(int m, int n, String[] board) {
        int result = 0;

        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] remove = checkRemove(m, n);

            int removeCount = remove(remove);
            if(removeCount == 0) break;
            result += removeCount;
            fillDown(m, n);
        }

        return result;
    }

    private static void fillDown(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            for (int j = 0; j < y; j++) {
                if(map[i][j] != '.') continue;

                int k = i;
                while(k > 0 && map[k][j] == '.') k--;
                if(map[k][j] == '.') continue;
                map[i][j] = map[k][j];
                map[k][j] = '.';
            }
        }
    }

    private static int remove(boolean[][] remove) {
        int count = 0;

        for (int i = 0; i < remove.length; i++) {
            for (int j = 0; j < remove[i].length; j++) {
                if (remove[i][j]) {
                    map[i][j] = '.';
                    count++;
                }
            }
        }

        return count;
    }

    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};
    private static boolean[][] checkRemove(int x, int y) {
        boolean[][] checked = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                char target = map[i][j];
                if(target == '.') continue;

                boolean flag = true;
                for (int d = 1; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= x || ny >= y || target != map[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    checked[nx][ny] = true;
                }
            }
        }

        return checked;
    }

}
