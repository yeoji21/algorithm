package inflean.rtg;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        new Main2().solution(n);
    }

    public void solution(int n) {
        if(n == 0) return;
        solution(n/2);
        System.out.print(n%2);
    }
}
