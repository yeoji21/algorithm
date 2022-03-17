package inflean.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main6_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = getIntToken(st);
        int K = getIntToken(st);

        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            num[i] = getIntToken(st);
            if(num[i] == 0) zeros.add(i);
        }

        int max = Integer.MIN_VALUE;
        int used = 0;
        int minIndex = 0;
        for (int i = 0; i < zeros.size(); i++) {
            int count = 0;
            Integer idx = zeros.get(i);
            num[idx] = 1;
            if(used < K) used++;
            else num[zeros.get(minIndex++)] = 0;

            int left = idx - 1, right = idx + 1;
            while (left >= 0 && num[left--] == 1) count++;
            while (right < N && num[right++] == 1) count++;
            max = Math.max(max, count + 1);
        }
        System.out.println(max);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}
