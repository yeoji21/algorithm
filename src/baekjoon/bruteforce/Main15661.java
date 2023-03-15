package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main15661 {
    private StringBuilder answer = new StringBuilder();
    /*
    n명을 두 팀으로 나누기 (1~n번)
    인원수 달라도 되는데 한 팀에 1명 이상이어야 함
    능력치 차이를 최소로
     */
    private int n, min = Integer.MAX_VALUE;
    private int[][] chemi;
    private List<Integer> teamA = new ArrayList<>(), teamB = new ArrayList<>();
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        chemi = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chemi[i][j] = reader.nextInt();
            }
        }

        solution(0, 0, new boolean[n]);
        System.out.println(min);
    }

    private void solution(int depth, int start, boolean[] team) {
        if(depth > 0 && depth < n){
            calcDiff(team);
        }
        if(depth >= n) return;

        for(int i = start; i < n; i++){
            if(team[i]) continue;
            team[i] = true;
            solution(depth + 1, i + 1, team);
            team[i] = false;
        }
    }

    void calcDiff(boolean[] team){
        teamA.clear();
        teamB.clear();
        for(int i = 0; i < n; i++){
            if(team[i]){
                teamA.add(i);
            }else{
                teamB.add(i);
            }
        }

        min = Math.min(min, Math.abs(calcSum(teamA) - calcSum(teamB)));
    }

    int calcSum(List<Integer> team){
        int sum = 0;
        for(int i = 0; i < team.size(); i++){
            for(int j = i + 1; j < team.size(); j++){
                sum += chemi[team.get(i)][team.get(j)];
                sum += chemi[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new Main15661().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
