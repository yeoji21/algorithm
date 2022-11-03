package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main11559 {
    private char[][] map = new char[12][6];
    private boolean[][] drop;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean flag;
        int answer = 0;
        while(true) {
            drop = new boolean[12][6];
            flag = false;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == '.') continue;
                    boolean puyo = BFS(i, j);
                    if(puyo) flag = true;
                }
            }
            dropColumns();
            if(!flag) break;
            answer++;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void dropColumns() {
        for (int column = 0; column < 6; column++) {
            for (int row = 11; row >= 0; row--) {
                if(map[row][column] == '.'){
                    int idx = row;
                    while(idx > 0 && map[idx][column] == '.')
                        idx--;
                    char temp = map[idx][column];
                    map[idx][column] = map[row][column];
                    map[row][column] = temp;
                }
            }
        }
    }

    private boolean BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] checked = new boolean[12][6];
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx >= 12 || nx < 0 || ny >= 6 || ny < 0) continue;
                if(checked[nx][ny] || map[x][y] != map[nx][ny]) continue;
                checked[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        if(count >= 4) {
            for (int i = 0; i < checked.length; i++) {
                for (int j = 0; j < checked[0].length; j++) {
                    if (checked[i][j]) {
                        map[i][j] = '.';
                        drop[i][j] = true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Main11559().solv();
    }
}
