package array;

import java.io.*;
import java.util.*;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[][] nums = new Integer[n][n];
        for (int i = 0; i < n; i++)
            nums[i] = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        new Main10().solution(nums, n);
    }

    public void solution(Integer[][] nums, int n) {
        List<int[]> co = new ArrayList<>();
        co.add(new int[]{-1, 0});
        co.add(new int[]{1, 0});
        co.add(new int[]{0, -1});
        co.add(new int[]{0, 1});

        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] coor : co) {
                    int index1 = i + coor[0];
                    int index2 = j + coor[1];
                    int sum = 0;
                    if (index1 >= n || index1 < 0 || index2 >= n || index2 < 0) {
                        count++;
                        continue;
                    }
                    sum = nums[index1][index2];
                    if(nums[i][j] > sum) count ++;
                    else break;
                }
                if (count == 4) total ++;
            }
        }
        System.out.println(total);
    }

    public void solution2(Integer[][] nums, int n) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < n && nx>=0 && ny <n&& ny >=0 && nums[i][j] <= (int) nums[nx][ny]){
                        flag = false;
                        break;
                    }
                }
                if (flag) count ++;
            }
        }
        System.out.println(count);
    }
}
