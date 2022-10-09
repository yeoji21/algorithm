package programmers_level2;

public class 방문_길이 {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public int solution(String dirs) {
        boolean[][][] matrix = new boolean[11][11][4];
        String commands = "UDRL";
        int answer = 0;

        int x = 5;
        int y = 5;
        for (int i = 0; i < dirs.length(); i++) {
            int idx = commands.indexOf(dirs.charAt(i));
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if(nx >= 11 || nx < 0 || ny >= 11 || ny < 0) continue;
            if(!matrix[nx][ny][idx])
                answer++;
            matrix[nx][ny][idx] = true;
            matrix[x][y][reverse(idx)] = true;
            x = nx;
            y = ny;
        }

        return answer;
    }

    public int reverse(int direction) {
        return direction % 2 == 0 ? direction + 1 : direction - 1;
    }
}
