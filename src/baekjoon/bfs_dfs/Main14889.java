package baekjoon.bfs_dfs;

import java.util.*;

public class Main14889 {
    static int[][] map;
    static int n;
    static int[] checked;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        checked = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        new Main14889().solution();
    }

    public void solution() {
        getTeam(0, 0);
        System.out.println(result);
    }

    private void getTeam(int level, int count) {
        if (count == n / 2) {
            getScore();
            return;
        }
        else{
            for (int i = level; i < n; i++) {
                if(checked[i] == 0){
                    checked[i] = 1;
                    getTeam(i, count + 1);
                    checked[i] = 0;
                }
            }
        }
    }


    private void getScore() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(checked[i] == 1 && checked[j] == 1){
                    teamA += map[i][j];
                    teamA += map[j][i];
                }
                if (checked[i] == 0 && checked[j] == 0) {
                    teamB += map[i][j];
                    teamB += map[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(teamA - teamB));
    }
}
