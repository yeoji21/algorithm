package inflean.string;

import java.io.*;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main7().solution(targetStr);
    }

    public void solution(String targetStr) {
        targetStr = targetStr.toLowerCase();
        char[] targetChars = targetStr.toCharArray();
        int rt=0, lt=targetChars.length-1;

        while (rt < lt) {
            if(targetChars[rt++] == targetChars[lt--]);

            else{
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");
    }

    public void solution2(String targetStr) {
        targetStr = targetStr.toLowerCase();
        String reversedTarget = new StringBuilder(targetStr).reverse().toString();
        if (reversedTarget.equalsIgnoreCase(targetStr))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
