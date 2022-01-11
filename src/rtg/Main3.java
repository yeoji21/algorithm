package rtg;

import java.io.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int result = new Main3().solution(n);
        System.out.println(result);
    }

    public int solution(int n) {
        if(n == 1) return 1;
        return n * solution(n - 1);
    }
}
