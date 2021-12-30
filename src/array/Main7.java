package array;

import java.io.*;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String[] split = in.readLine().replace(" ","").split("0");
        new Main7().solution(split);
    }

    public void solution(String[] split) {
        int score = 0;

        for (String strNum : split)
            for (int i = 1; i <= strNum.length(); i++)
                score += i;

        System.out.println(score);
    }
}
