package string;

import java.io.*;
import static java.lang.Character.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main2().solution(targetStr);
    }

    public void solution(String targetStr) {
        char[] result = targetStr.toCharArray();

        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if (isLowerCase(c))
                result[i] = toUpperCase(c);
            else
                result[i] = toLowerCase(c);
        }

        System.out.println(result);
    }
}
