package string;

import java.io.*;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = in.readLine();

        new Main3().solution(targetStr);
    }

    public void solution(String targetStr) {
        String[] splitStr = targetStr.split(" ");
        String maxLengthVocab = "";

        for (String str : splitStr) {
            if(str.length() > maxLengthVocab.length())
                maxLengthVocab = str;
        }

        System.out.println(maxLengthVocab);
    }
}