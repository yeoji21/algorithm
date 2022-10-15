package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer); // 배열 길이
        int M = getIntToken(tokenizer); // 숫자 변경 횟수
        int K = getIntToken(tokenizer); // 구간 합을 구하는 횟수

        long[] nums = new long[N];
        long[] sum = new long[N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            nums[i] = getLongToken(tokenizer);
            sum[i] += nums[i];
            sum[i] += i != 0 ? sum[i - 1] : 0;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int command = getIntToken(tokenizer);
            if (command == 1) {
                int idx = getIntToken(tokenizer) - 1;
                long newValue = getLongToken(tokenizer);
                long oldValue = nums[idx];
                nums[idx] = newValue;
                for (int j = idx; j < sum.length; j++) {
                    sum[j] += (newValue - oldValue);
                }
            }else{
                int start = getIntToken(tokenizer) - 1;
                int end = getIntToken(tokenizer) - 1;
                long answer = sum[end];
                answer -= start != 0 ? sum[start - 1] : 0;
                sb.append(answer).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static long getLongToken(StringTokenizer tokenizer) {
        return Long.parseLong(tokenizer.nextToken());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }

    private static long[] nums;
    private static long[] tree;

    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer); // 배열 길이
        int M = getIntToken(tokenizer); // 숫자 변경 횟수
        int K = getIntToken(tokenizer); // 구간 합을 구하는 횟수

        nums = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i < N + 1; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        init(1, 1, N);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int command = getIntToken(tokenizer);

            if (command == 1) {
                int idx = getIntToken(tokenizer);
                long value = getLongToken(tokenizer);
                long diff = value - nums[idx];
                nums[idx] = value;
                update(1, 1, N, idx, diff);
            } else {
                int start = getIntToken(tokenizer);
                int end = getIntToken(tokenizer);
                answer.append(sum(1, 1, N, start, end))
                        .append("\n");
            }
        }
        System.out.println(answer.toString());
    }

    private static long sum(int now, int left, int right, int start, int end) {
        if(right < start || left > end) return 0;
        if(start <= left && right <= end) return tree[now];

        int mid = left + (right - left) / 2;
        return sum(2 * now, left, mid, start, end) + sum(2 * now + 1, mid + 1, right, start, end);
    }

    private static void update(int now, int left, int right, int idx, long diff) {
        if(idx < left || idx > right) return;
        tree[now] += diff;
        if (left != right) {
            int mid = left + (right - left) / 2;
            update(2 * now, left, mid, idx, diff);
            update(2 * now + 1, mid + 1, right, idx, diff);
        }
    }

    private static long init(int node, int left, int right) {
        if(left == right)
            return tree[node] = nums[left];
        int mid = left + (right - left) / 2;
        return tree[node] = init(2 * node, left, mid) + init(node * 2 + 1, mid + 1, right);
    }
}
