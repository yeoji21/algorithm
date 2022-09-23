class Solution {
    public static void main(String[] args) {
        int solution = solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        System.out.println(solution);
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while(true){
            boolean[][] checked = getRemove(m, n, map);
            int count = remove(checked, map);
            if(count == 0) break;
            answer += count;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }
    private static int remove(boolean[][] checked, char[][] map) {
        int count = 0;
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if(checked[i][j]) count++;
            }
        }

        for (int x = checked.length - 1; x >= 0; x--) {
            for (int y = 0; y < checked[0].length; y++) {
                int idx = x;
                while (idx > 0 && map[idx][y] == '.') idx--;

                if(map[idx][y] == '.') continue;
                map[x][y] = map[idx][y];
                map[idx][y] = '.';
            }
        }

        return count;
    }


    private static int remove(int m, int n, char[][] map, boolean[][] checked) {
        int remove = 0;
        for (int y = 0; y < n; y++) {
            for (int x = m - 1; x >= 0; x--) {
                if (checked[x][y]) {
                    int idx = x;
                    while (idx - 1 > 0 && checked[idx][y]) idx--;

                    int count = x - idx;
                    remove += count;
                    for (int i = 0; i < count; i++) {
                        if (idx < 0) {
                            map[x--][y] = '1';
                        } else {
                            map[x--][y] = map[idx--][y];
                            map[idx + 1][y] = '1';
                        }
                    }
                }
            }
        }
        return remove;
    }

    private static boolean[][] getRemove(int m, int n, char[][] map) {
        int[] dx = {-1, -1, 0};
        int[] dy = {-1, 0, -1};

        boolean[][] checked = new boolean[m][n];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                char character = map[i][j];
                boolean flag = true;
                for (int d = 0; d < 3; d++) {
                    if (map[i + dx[d]][j + dy[d]] != character) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    checked[i][j] = true;
                    for (int d = 0; d < 3; d++) {
                        checked[i + dx[d]][j + dy[d]] = true;
                    }
                }
            }
        }
        return checked;
    }
}