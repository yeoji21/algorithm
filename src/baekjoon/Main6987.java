package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main6987 {
    private int[][] group;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        StringBuilder answer = new StringBuilder();
        group = new int[6][3];
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            tokenizer = new StringTokenizer(br.readLine());
            for (int n = 0; n < 6; n++) {
                for (int m = 0; m < 3; m++) {
                    group[n][m] = getIntToken(tokenizer);
                    sum += group[n][m];
                }
            }
            if(sum != 30){
                answer.append("0").append(" ");
                continue;
            }
            boolean result = dfs(0, 1, 0);
            answer.append(result ? "1" : "0").append(" ");
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean dfs(int teamA, int teamB, int count) {
        if(count == 15)
            return true;
        if(teamB >= 6){
            teamA++;
            teamB = teamA + 1;
        }

        if (group[teamA][0] > 0 && group[teamB][2] > 0) {
            group[teamA][0]--;
            group[teamB][2]--;
            if(dfs(teamA, teamB + 1, count + 1))
                return true;
            group[teamA][0]++;
            group[teamB][2]++;
        }

        if (group[teamA][1] > 0 && group[teamB][1] > 0) {
            group[teamA][1]--;
            group[teamB][1]--;
            if(dfs(teamA, teamB + 1, count + 1))
                return true;
            group[teamA][1]++;
            group[teamB][1]++;
        }

        if (group[teamA][2] > 0 && group[teamB][0] > 0) {
            group[teamA][2]--;
            group[teamB][0]--;
            if(dfs(teamA, teamB + 1, count + 1))
                return true;
            group[teamA][2]++;
            group[teamB][0]++;
        }

        return false;
    }


    public static void main(String[] args) throws Exception {
        new Main6987().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}























