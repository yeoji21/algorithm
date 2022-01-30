package na.greedy;

import java.util.*;

public class Main2 {
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = sc.nextInt();

        new Main2().solution(num);
    }

    public void solution(int[] num) {
        int sum = 0;
        Arrays.sort(num);

        int max = num[n-1];
        int second = num[n-2];

        int count = 0;
        for (int i = 0; i < m; i++) {
            if(count < k) {
                sum += max;
                count ++;
            }
            else {
                sum += second;
                count = 0;
            }
        }

        System.out.println(sum);
    }

    public void solution2(int[] num) {
        int sum = 0;
        Integer[] sorted = Arrays.stream(num).boxed().sorted(Comparator.comparingInt(x -> -x)).toArray(Integer[]::new);

        int first = sorted[0];
        int second = sorted[1];

        int count = (m / (k + 1)) * k + (m % (k + 1));
        sum += count * first;

        sum += (m - count) * second;

        System.out.println(sum);
    }
}
