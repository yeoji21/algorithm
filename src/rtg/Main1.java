package rtg;

import java.io.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        new Main1().solution(n);
    }

    public void solution(int n) {
        if(n == 0) return;
        solution(n-1);
        System.out.println(n);
    }
}
