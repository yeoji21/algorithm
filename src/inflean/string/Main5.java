package inflean.string;

import java.io.*;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main5().solution(targetStr);
    }

    public void solution(String targetStr) {
        char[] targetChars = targetStr.toCharArray();
        int lt = 0, rt = targetChars.length-1;
        while(lt < rt) {
            if (!Character.isAlphabetic(targetChars[lt]))
                lt++;
            else if (!Character.isAlphabetic(targetChars[rt]))
                rt--;
            else {
                char temp = targetChars[rt];
                targetChars[rt--] = targetChars[lt];
                targetChars[lt++] = temp;
            }
        }
        System.out.println(targetChars);
    }
}
