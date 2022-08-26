package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {1, 0, -1, 0};

    public static int[] solution(String[][] places) {
        int[] result = new int[5];
        for (int p = 0; p < places.length; p++) {
            result[p] = inspectRoom(initializeMap(places[p])) ? 1 : 0;
        }

        return result;
    }

    private static char[][] initializeMap(String[] places) {
        char[][] room = new char[5][5];
        for (int i = 0; i < room.length; i++) {
            room[i] = places[i].toCharArray();
        }
        return room;
    }

    private static boolean inspectRoom(char[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(room[i][j] == 'P') {
                    if(!distanceCheck(room, i, j)) return false;
                }
            }
        }
        return true;
    }

    private static boolean distanceCheck(char[][] room, int x, int y) {
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

                    if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                    if(checked[nx][ny] || distance > 2) continue;

                    checked[nx][ny] = true;
                    if(room[nx][ny] == 'X') continue;
                    if(room[nx][ny] == 'P') return false;

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
