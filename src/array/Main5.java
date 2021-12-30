package array;

import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        new Main5().solution(num);
    }

    public void solution(int num) {
        int[] numArray = new int[num + 1];
        int count = 0;

        for (int i = 2; i < num; i++) {
            if (numArray[i] == 0) {
                count++;

                for (int j=2; i*j < num; j++){
                    numArray[i*j] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
