package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main14502 {
    /*
    새로 세울 벽의 개수 3개
    3개 다 세워야 함
    0 빈칸
    1 벽
    2 바이러스
    안전 영역의 최대값을 구하시오

    조합, BFS
     */
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] map;
    private List<int[]> virus;
    private List<int[]> emptyRooms;
    private boolean[][] checked;
    private int N, M;
    private int answer = 0;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        emptyRooms = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 0) emptyRooms.add(new int[]{i, j});
                if(map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        combination(new boolean[emptyRooms.size()], new int[3], 0, 0);
        System.out.println(answer);
    }

    private void combination(boolean[] checked, int[] selected, int level, int start) {
        if (level == 3) {
            for (int i = 0; i < selected.length; i++) {
                int[] room = emptyRooms.get(selected[i]);
                map[room[0]][room[1]] = 1;
            }
            answer = Math.max(answer, BFS());
            for (int i = 0; i < selected.length; i++) {
                int[] room = emptyRooms.get(selected[i]);
                map[room[0]][room[1]] = 0;
            }
            return;
        }

        for (int i = start; i < emptyRooms.size(); i++) {
            if(checked[i]) continue;
            checked[i] = true;
            selected[level] = i;
            combination(checked, selected, level + 1, i + 1);
            checked[i] = false;
        }
    }

    private int BFS() {
        Queue<int[]> q = new LinkedList<>();
        checked = new boolean[N][M];
        for (int i = 0; i < virus.size(); i++) {
            q.add(virus.get(i));
            checked[virus.get(i)[0]][virus.get(i)[1]] = true;
        }

        int empty = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if(checked[nx][ny] || map[nx][ny] == 1) continue;
                if(map[nx][ny] == 0) empty++;
                checked[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        return emptyRooms.size() - 3 - empty;
    }

    public static void main(String[] args) throws Exception {
        new Main14502().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
