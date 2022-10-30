package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3568 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] words = br.readLine().split(" ");
        String defaultType = words[0];
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            StringBuilder variable = new StringBuilder();
            word = word.replaceAll("[,;]", "");
            String symbol = word.replaceAll("\\w", "");
            String name = word.replaceAll("\\W", "");

            variable.append(defaultType);
            for (int s = symbol.length() - 1; s >= 0; s--) {
                if(symbol.charAt(s) == ']')
                    variable.append('[');
                else if(symbol.charAt(s) == '[')
                    variable.append(']');
                else
                    variable.append(symbol.charAt(s));
            }
            variable.append(" ").append(name).append(";").append("\n");
            answer.append(variable);
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main3568().solv();
    }
}
