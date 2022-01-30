package inflean.dfs_bfs;

import java.util.*;

public class Main2 {
    static int[] dogs;
    static int limitKg;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        limitKg = sc.nextInt();
        int n = sc.nextInt();
        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }
        new Main2().solution(0, 0);
        System.out.println(maxSum);
    }

    public void solution(int dog, int sum) {
        if (dog == dogs.length){
            if (sum <= limitKg)
                maxSum = Math.max(maxSum, sum);
            return;
        }
        if (sum > limitKg) return;

        solution(dog+1, sum+dogs[dog]);
        solution(dog+1, sum);
    }
}
