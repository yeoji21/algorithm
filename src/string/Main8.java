package string;

import java.io.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main8().solution(targetStr);
    }

    public void solution(String targetStr) {
        String removedTarget = targetStr.replaceAll("[\\W\\d]", "");

        String reversedTarget = new StringBuilder(removedTarget).reverse().toString();
        if(removedTarget.equalsIgnoreCase(reversedTarget))
            System.out.println("YES");
        else{
            System.out.println("NO");
        }
    }
}
