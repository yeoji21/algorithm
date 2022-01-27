import java.util.*;

public class Main {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] num = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        new Main().solution(num);
    }

    public void solution(int[] num) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] > dp[len]) {
                len ++;
                dp[len] = num[i];
            }else{
                int idx = binarySearch(0, len, num[i]);
                dp[idx] = num[i];
            }
        }
        System.out.println(Arrays.stream(dp).filter(x -> x!=0).count());
    }

    private int binarySearch(int left, int right, int key) {
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (dp[mid] < key)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }
}