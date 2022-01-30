package inflean.string;

import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine());

        List<String> vocabs = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            vocabs.add(in.readLine());
        }

        new Main4().solution(vocabs);
    }

    public void solution(List<String> vocabs) {

        for (String vocab : vocabs) {
            StringBuilder result = new StringBuilder();
            for (int i = vocab.length()-1; i >= 0; i--) {
                result.append(vocab.charAt(i));
            }
            System.out.println(result);
        }
    }

    public void solution2(List<String> vocabs) {
        vocabs.forEach(vocab -> System.out.println(new StringBuilder(vocab).reverse()));
    }

    public void solution3(List<String> vocabs) {
        for (String vocab : vocabs) {
            char[] charsVocab = vocab.toCharArray();
            int lp = 0, rp = charsVocab.length-1;

            while(lp < rp){
                char temp = charsVocab[rp];
                charsVocab[rp--] = charsVocab[lp];
                charsVocab[lp++] = temp;
            }
            System.out.println(charsVocab);
        }
    }
}
