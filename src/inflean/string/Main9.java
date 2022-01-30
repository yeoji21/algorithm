package inflean.string;

import java.io.*;

public class Main9 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main9().solution(targetStr);
    }

    public void solution(String targetStr) {
        String numberOnlyStr = targetStr.replaceAll("[\\D]", "");
        System.out.println(Integer.parseInt(numberOnlyStr));
    }
}
