package programmers_level2;

public class 방문_길이 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int solution(String dirs) {
        int result = 0;
        int length = 11;
        boolean[][][] checked = new boolean[length][length][4];
        int x = 5;
        int y = 5;

        for (char dir : dirs.toCharArray()) {
            int d = moveTo(dir);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= length || ny < 0 || ny >= length) continue;
            if (!checked[nx][ny][d]) {
                checked[nx][ny][d] = true;
                // 왕복으로 돌아오는 경우를 위해 반대편에서 오는 경우도 체크
                d = d % 2 == 0 ? d + 1 : d - 1;
                checked[x][y][d] = true;
                result++;
            }

            x = nx;
            y = ny;
        }

        return result;
    }

    private static int moveTo(char dir) {
        if(dir == 'U'){
            return 0;
        } else if (dir == 'D') {
            return 1;
        } else if (dir == 'R') {
            return 2;
        } else if (dir == 'L') {
            return 3;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
