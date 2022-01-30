package inflean.string;

import java.io.*;

public class Main1 {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();
        char findChar = in.readLine().charAt(0);

        System.out.println(new Main1().solution(targetStr, findChar));
    }

    public int solution(String targetStr, char findChar) {
        targetStr = targetStr.toLowerCase();
        findChar = Character.toLowerCase(findChar);
        int count = 0;
        for (int i = 0; i < targetStr.length(); i++) {
            if (targetStr.charAt(i) == findChar)
                count++;
        }

        return count;
    }
}

