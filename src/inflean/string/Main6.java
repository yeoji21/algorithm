package inflean.string;

import java.io.*;
import java.util.LinkedHashSet;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main6().solution(targetStr);
    }

    public void solution(String targetStr) {
        char[] targetChars = targetStr.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char aChar : targetChars) {
            set.add(aChar);
        }

        set.forEach(System.out::print);
    }
}
