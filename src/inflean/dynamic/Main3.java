package inflean.dynamic;

import java.util.*;

public class Main3 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] distance = new int[n];
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        new Main3().solution(num, distance);
    }

    public void solution(int[] num, int[] distance) {

        for (int i = 0; i < num.length; i++) {
            distance[i] = 1;

            for (int j = 0; j < i; j++) {
                if(num[i] > num[j]){
                    distance[i] = Math.max(distance[j] + 1, distance[i]);
                }
            }
        }

        System.out.println(Arrays.stream(distance).max().getAsInt());
    }
}
