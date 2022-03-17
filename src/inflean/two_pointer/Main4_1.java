package inflean.two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < num.length; i++) num[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        int idx = 0;
        int sum = num[0];

        for (int i = 1; i < num.length; i++) {
            sum += num[i];
            while(sum > M) sum -= num[idx++];
            if(sum == M) count ++;
        }

        System.out.println(count);
    }
}
