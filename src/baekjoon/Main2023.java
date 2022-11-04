package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2023 {
    private List<Integer> answer;
    private int n;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] primes = {2, 3, 5, 7};
        n = Integer.parseInt(br.readLine());
        if(n == 1){
            for (int i = 0; i < primes.length; i++) {
                answer.add(primes[i]);
            }
        }
        else {
            for (int i = 0; i < primes.length; i++) {
                dfs(0, primes[i]);
            }
            Collections.sort(answer);
        }
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    private int[] odds = {1, 3, 5, 7, 9};

    private void dfs(int level, int num) {
        if(level != 0) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return;
            }
        }

        if (level == n - 1) {
            answer.add(num);
            return;
        }

        for (int i = 0; i < odds.length; i++) {
            dfs(level + 1, num * 10 + odds[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2023().solv();
    }
}
