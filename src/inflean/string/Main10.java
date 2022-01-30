package inflean.string;

import java.io.*;
import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();
        String[] strs = targetStr.split(" ");

        new Main10().solution(strs[0], strs[1].charAt(0));
    }

    private void solution(String targetString, char findChar) {
        char[] targetChars = targetString.toCharArray();
        StringBuilder builder = new StringBuilder("");
        int[] result = new int[targetChars.length];

        int score = 1000;

        for (int i = 0; i<targetString.length(); i++){
            if (targetString.charAt(i) == findChar){
                score = 0;
                result[i] = score;
            }
            else
                result[i] = ++score;
        }

        score = 1000;
        for (int i = targetChars.length-1; i >= 0; i--) {
            if (targetString.charAt(i) == findChar)
                score = 0;
            else
                result[i] = Math.min(result[i], ++score);
        }

        Arrays.stream(result).forEach(r -> System.out.print(r + " "));
    }
}


