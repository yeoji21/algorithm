package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {
    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;
    private static int[] nums;
    private static int[] operands;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operands = new int[4];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operands[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dfs(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int sum, int level) {
        if (level == nums.length) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        if(operands[0] != 0) {
            operands[0]--;
            dfs(sum + nums[level], level + 1);
            operands[0]++;
        }
        if(operands[1] != 0) {
            operands[1]--;
            dfs(sum - nums[level], level + 1);
            operands[1]++;
        }
        if(operands[2] != 0) {
            operands[2]--;
            dfs(sum * nums[level], level + 1);
            operands[2]++;
        }
        if(operands[3] != 0){
            operands[3]--;
            dfs(sum / nums[level], level + 1);
            operands[3]++;
        }
    }
}