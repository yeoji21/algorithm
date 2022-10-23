package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1789 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        int answer = 0;
        int num = 1;
        while (sum < N) {
            sum += num++;
            answer++;
        }

        System.out.println(sum == N ? answer : answer - 1);
    }
}
