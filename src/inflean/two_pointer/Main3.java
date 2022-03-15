package inflean.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = getIntToken(st);
        int M = getIntToken(st);
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num.length; i++) num[i] = getIntToken(st);

        int sum = 0;
        for (int i = 0; i < M; i++) sum += num[i];

        int max = sum;
        int left = 0;
        for (int i = M; i < num.length; i++) {
            sum -= num[left++];
            sum += num[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}