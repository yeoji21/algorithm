package na.greedy;

import java.util.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][m];

        int[] mins = new int[n];
        for (int i = 0; i < n; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                num[i][j] = sc.nextInt();
                max = Math.min(num[i][j], max);
            }
            mins[i] = max;
        }

        System.out.println(Arrays.stream(mins).max().getAsInt());
    }
}
