import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] place) {
        char[][] room = new char[5][5];
        for (int i = 0; i < place.length; i++) {
            String row = place[i];
            room[i] = row.toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(room[i][j] == 'P')
                    if(!calcDistance(room, i, j))
                        return false;
            }
        }

        return true;
    }

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private boolean calcDistance(char[][] room, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] checked = new boolean[5][5];
        queue.add(new Point(x, y));
        checked[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    int distance = Math.abs(x - nx) + Math.abs(y - ny);
                    if(distance > 2) continue;
                    if(nx >= 5 || nx < 0 || ny >= 5 || ny < 0) continue;
                    if(checked[nx][ny] || room[nx][ny] == 'X') continue;
                    if(room[nx][ny] == 'P') return false;

                    checked[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return true;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
