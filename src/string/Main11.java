package string;

import java.io.*;

public class Main11 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main11().solution(targetStr);
    }

    public void solution(String targetStr) {
        char[] targetChars = targetStr.toCharArray();
        StringBuilder builder = new StringBuilder();
        char target = '&';

        for (int i = 0; i < targetChars.length; i++) {
            if (target == targetChars[i])
                continue;
            target = targetChars[i];
            int count = 0;
            for (char tmp : targetStr.substring(i).toCharArray()){
                if (tmp == target)
                    count ++;
                else
                    break;
            }
            builder.append(target).append(count>1?count:"");
        }

        System.out.println(builder);
    }
}
