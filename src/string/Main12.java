package string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main12 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());
        String targetStr = in.readLine();

        new Main12().solution(targetStr, num);
    }

    public void solution(String targetStr, int num) {
        List<String> targetVocabs = new ArrayList<>();
        for (int i = 0; i < num*7; i+=7) {
            targetVocabs.add(targetStr.substring(i, i + 7));
        }

        for (String vocab : targetVocabs){
            String replacedVocab = vocab.replace("#", "1").replace("*", "0");
            int decimalVocab = Integer.parseInt(replacedVocab, 2);
            System.out.print((char)decimalVocab);
        }
    }xw
}
