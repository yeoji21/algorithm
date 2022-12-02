package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main16988 {
    /*
    0 빈 칸
    1 내 돌
    2 쟤 돌

    죽일 돌 근처가 1 아니면 2 아니면 장외 -> 근처에 0이 있으면 안됨
    한 덩어리에 속한 돌들의 근처가 0이 아니어야 함

    먼저 BFS로 덩어리들을 찾아서 list에 넣어놓고
    돌 넣을 자리를 조합으로 구한 뒤에
    덩어리 list 돌면서 확인
     */

    private int N, M;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] map;
    private boolean[][] checked;
    private int answer = 0;
    private List<int[]> emptySpace;
    private List<List<int[]>> enemy;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        checked = new boolean[N][M];
        emptySpace = new ArrayList<>();
        enemy = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 0) emptySpace.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!checked[i][j] && map[i][j] == 2) {
                    BFS(i, j);
                }
            }
        }

        combination(new boolean[emptySpace.size()], new int[2], 0, 0);
        System.out.println(answer);
    }

    private void combination(boolean[] checked, int[] selected, int level, int start) {
        if (level == 2) {
            for (int i = 0; i < selected.length; i++) {
                int[] space = emptySpace.get(selected[i]);
                map[space[0]][space[1]] = 1;
            }
            eliminate();
            for (int i = 0; i < selected.length; i++) {
                int[] space = emptySpace.get(selected[i]);
                map[space[0]][space[1]] = 0;
            }
            return;
        }
        for (int i = start; i < emptySpace.size(); i++) {
            if(checked[i]) continue;
            checked[i] = true;
            selected[level] = i;
            combination(checked, selected, level + 1, i + 1);
            checked[i] = false;
        }
    }

    private void eliminate() {
        int sum = 0;
        for (List<int[]> group : enemy) {
            boolean check = true;
            for (int[] now : group) {
                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                    if(map[nx][ny] == 0){
                        check = false;
                        break;
                    }
                }
            }
            if (!check) continue;
            sum += group.size();
        }
        answer = Math.max(answer, sum);
    }

    private void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        checked[x][y] = true;
        List<int[]> group = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] now = q.poll();
            group.add(now);
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if(checked[nx][ny] || map[nx][ny] != 2) continue;

                checked[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        enemy.add(group);
    }

    public static void main(String[] args) throws Exception {
        new Main16988().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
