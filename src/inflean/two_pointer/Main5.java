package inflean.two_pointer;

import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        new Main5().solution(n);
    }

    public void solution(int n) {
        int sum = 0;
        int count = 0;
        int rt = 0, lt = 0;

        while (rt >= lt && rt < n/2+1) {
            sum += ++rt;
            if (sum == n){
                count ++;
                sum -= ++lt;
            }
            while (sum > n){
                sum -= ++lt;
                if(sum == n){
                    count++;
                    sum -= ++lt;
                }
            }
        }

        System.out.println(count);
    }
}
