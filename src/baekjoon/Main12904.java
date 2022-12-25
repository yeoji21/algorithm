package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12904 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        if(S.length() > T.length()) System.out.println(0);

        while(T.length() > S.length()){
            char last = T.charAt(T.length() - 1);
            T = T.substring(0, T.length() - 1);
            if(last == 'B'){
                T = new StringBuilder(T).reverse().toString();
            }
        }

        if(T.equals(S)) System.out.println(1);
        else System.out.println(0);
    }


    public static void main(String[] args) throws Exception {
        new Main12904().solv();
    }
}
