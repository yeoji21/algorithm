package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main7569 {
    private int[] dx = {1, 0, -1, 0, 0, 0};
    private int[] dy = {0, 1, 0, -1, 0, 0};
    private int[] dh = {0, 0, 0, 0, 1, -1};
    private int[][][] map;
    private int M, N, H;
    private int totalTomatos;
    private List<int[]> tomatos;
    private int answer;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        M = getIntToken(tokenizer);
        N = getIntToken(tokenizer);
        H = getIntToken(tokenizer);
        tomatos = new ArrayList<>();
        map = new int[N][M][H];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j][h] = getIntToken(tokenizer);
                    if(map[i][j][h] != -1) totalTomatos++;
                    if(map[i][j][h] == 1) tomatos.add(new int[]{i, j, h});
                }
            }
        }

        answer = tomatos.size() == totalTomatos ? 0 : BFS();
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] checked = new boolean[N][M][H];
        for (int i = 0; i < tomatos.size(); i++) {
            q.add(tomatos.get(i));
            checked[tomatos.get(i)[0]][tomatos.get(i)[1]][tomatos.get(i)[2]] = true;
        }
        int day = 0;
        int count = 0;
        int greenTomatos = totalTomatos - tomatos.size();

        while (!q.isEmpty()) {
            int size = q.size();
            day++;
            while (size-- > 0) {
                int[] now = q.poll();
                for (int d = 0; d < 6; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    int nh = now[2] + dh[d];

                    if(rangeCheck(nx, ny, nh) || checked[nx][ny][nh]) continue;
                    if(map[nx][ny][nh] == -1) continue;

                    checked[nx][ny][nh] = true;
                    if(map[nx][ny][nh] == 0) {
                        map[nx][ny][nh] = 1;
                        count++;
                        if(count == greenTomatos) return day;
                    }
                    q.add(new int[]{nx, ny, nh});
                }
            }
        }

        return -1;
    }

    private boolean rangeCheck(int x, int y, int h) {
        return x >= N || x < 0 || y >= M || y < 0 || h >= H || h < 0;
    }

    public static void main(String[] args) throws Exception {
        new Main7569().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
