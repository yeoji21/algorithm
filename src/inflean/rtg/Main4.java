package inflean.rtg;

import java.io.*;

public class Main4 {
    static int[] fibo;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        fibo = new int[n + 1];
        new Main4().solution(n, fibo);
        for (int i = 1; i < fibo.length; i++)
            System.out.print(fibo[i] + " ");
    }

    public int solution(int n, int[] fibo) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1 || n == 2) return fibo[n] = 1;
        return fibo[n] = solution(n - 2, fibo) + solution(n - 1, fibo);
    }
}
