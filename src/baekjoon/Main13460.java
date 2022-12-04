package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int N, M;
    private char[][] map;
    private boolean[][][][] checked;
    private int[] red, blue;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R') red = new int[]{i, j};
                else if(map[i][j] == 'B') blue = new int[]{i, j};
            }
        }

        int answer = BFS();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS() {
        Queue<int[]> q = new LinkedList<>();
        checked = new boolean[N][M][N][M];
        q.add(new int[]{red[0], red[1], blue[0], blue[1]});
        checked[red[0]][red[1]][blue[0]][blue[1]] = true;

        int answer = 0;
        while (!q.isEmpty() && answer++ < 10) {
            int size = q.size();
            while (size-- > 0) {
                int[] balls = q.poll();

                for (int d = 0; d < 4; d++) {
                    int rx = balls[0];
                    int ry = balls[1];
                    int rmoved = 0;
                    boolean rgoal = false;
                    while (map[rx + dx[d]][ry + dy[d]] != '#') {
                        rx += dx[d];
                        ry += dy[d];
                        rmoved++;
                        if(map[rx][ry] == 'O') {
                            rgoal = true;
                            break;
                        }
                    }

                    int bx = balls[2];
                    int by = balls[3];
                    int bmoved = 0;
                    boolean bgoal = false;
                    while(map[bx + dx[d]][by + dy[d]] != '#') {
                        bx += dx[d];
                        by += dy[d];
                        bmoved++;
                        if(map[bx][by] == 'O') {
                            bgoal = true;
                            break;
                        }
                    }

                    if (rgoal || bgoal) {
                        if(bgoal) continue;
                        else return answer;
                    }

                    if(rx == bx && ry == by){
                        if(rmoved < bmoved){
                            bx -= dx[d];
                            by -= dy[d];
                        }else{
                            rx -= dx[d];
                            ry -= dy[d];
                        }
                    }

                    if(checked[rx][ry][bx][by]) continue;
                    checked[rx][ry][bx][by] = true;
                    q.add(new int[]{rx, ry, bx, by});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main13460().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
