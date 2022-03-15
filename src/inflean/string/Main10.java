package inflean.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String T = st.nextToken();
        char N = st.nextToken().charAt(0);
        int[] result = new int[T.length()];

        int k = 1000;
        for (int i = T.length()-1; i >= 0; i--) {
            char c = T.charAt(i);
            if(c == N) k = 0;
            result[i] = k++;
        }

        k = 1000;
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if(c == N) k = 0;
            result[i] = Math.min(result[i], k);
            k++;
        }

        Arrays.stream(result).forEach(c -> System.out.print(c + " "));
    }
}

