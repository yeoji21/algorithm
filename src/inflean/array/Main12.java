package inflean.array;

import java.util.*;
import java.util.stream.Collectors;

public class Main12 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //4
        int m = sc.nextInt(); //3

        int[][]nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        new Main12().solution(nums, n, m);
    }

    public void solution(int[][] nums, int studentNum, int examNum) {
        int count = 0;

        for (int i = 1; i < studentNum+1; i++) {
            for (int j = 1; j < studentNum+1; j++) {
                if (i == j) continue;
                int rank = 0;
                for (int k = 0; k < examNum; k++) {
                    List<Integer> rankList = Arrays.stream(nums[k]).boxed().collect(Collectors.toList());
                    if (rankList.indexOf(i) < rankList.indexOf(j))
                        rank ++;
                }
                if (rank == examNum) count ++;
            }
        }
        System.out.println(count);

    }
}
