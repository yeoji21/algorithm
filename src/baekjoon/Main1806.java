package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int S = getIntToken(tokenizer);
        tokenizer = new StringTokenizer(br.readLine());
        int[] nums = new int[N + 1];
        for (int i = 0; i < N; i++) {
            nums[i] = getIntToken(tokenizer);
        }

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        while (left <= right && right <= N) {
            if (sum < S) {
                sum += nums[right++];
            }else{
                answer = Math.min(answer, right - left);
                sum -= nums[left++];
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
