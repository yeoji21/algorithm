package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14889 {
    private int N;
    private int[][] map;
    private int answer = Integer.MAX_VALUE;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }

        DFS(0, 0, new boolean[N]);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int level, int start, boolean[] selected) {
        if (level == N / 2) {
            answer = Math.min(answer, calcGap(selected));
            return;
        }
        for (int i = start; i < N; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            DFS(level + 1, i + 1, selected);
            selected[i] = false;
        }

    }

    public int calcGap(boolean[] selected) {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                if(selected[i] && selected[j]) teamA += map[i][j];
                if(!selected[i] && !selected[j]) teamB += map[i][j];
            }
        }
        return Math.abs(teamA - teamB);
    }

    public static void main(String[] args) throws Exception {
        new Main14889().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
