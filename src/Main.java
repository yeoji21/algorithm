import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] num, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

//        DP();
        binarySearch();
    }

    private static void DP() {
        for (int i = 0; i < num.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void binarySearch() {
        int idx = 0;
        dp[idx++] = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > dp[idx - 1]) {
                dp[idx++] = num[i];
            }
            else {
                int index = lowerBound(num[i], 0, idx);
                dp[index] = num[i];
            }
        }

        System.out.println(Arrays.stream(dp).filter(n -> n != 0).count());
    }

    private static int lowerBound(int value, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(value <= dp[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}