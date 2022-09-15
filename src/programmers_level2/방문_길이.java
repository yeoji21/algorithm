package programmers_level2;

public class 방문_길이 {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public int solution(String dirs) {
        boolean[][][] map = new boolean[11][11][4];
        int x = 5, y = 5;
        int answer = 0;

        for (char command : dirs.toCharArray()) {
            int d = moveTo(command);
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) continue;

            if(!map[nx][ny][d]) {
                map[nx][ny][d] = true;
                int opposite = d % 2 == 0 ? d + 1 : d - 1;
                map[x][y][opposite] = true;
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }

    private int moveTo(char dir) {
        if (dir == 'U') {
            return 0;
        } else if (dir == 'D') {
            return 1;
        } else if (dir == 'R') {
            return 2;
        } else
            return 3;
    }
}
