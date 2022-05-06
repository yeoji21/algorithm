package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main14889 {
    private static int[][] map;
    private static int N, minStat = Integer.MAX_VALUE;
    private static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        checked = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeam(0, 0);

        System.out.println(minStat);
    }

    private static void divideTeam(int level, int count) {
        if (count == N / 2) {
            minStat = Math.min(minStat, calculateTeamStat());
        }
        else{
            for (int i = level; i < N; i++) {
                checked[i] = true;
                divideTeam(i + 1, count + 1);
                checked[i] = false;
            }
        }
    }

    private static int calculateTeamStat() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (checked[i] && checked[j]) {
                    teamA += map[i][j];
                    teamA += map[j][i];
                }
                if (!checked[i] && !checked[j]) {
                    teamB += map[i][j];
                    teamB += map[j][i];
                }
            }
        }

        return Math.abs(teamA - teamB);
    }
}