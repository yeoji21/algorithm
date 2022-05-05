package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1759 {
    private static int L, C;
    private static char[] alphabets;
    private static boolean[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphabets = new char[C];
        checked = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) alphabets[i] = st.nextToken().charAt(0);
        Arrays.sort(alphabets);

        solvePassword(0, 0);
    }

    private static void solvePassword(int level, int select) {
        if (select == L) {
            Password password = new Password();
            if(password.validation())
                System.out.println(password.password);
        }
        else{
            for (int i = level; i < C; i++) {
                checked[i] = true;
                solvePassword(i + 1, select + 1);
                checked[i] = false;
            }
        }
    }

    private static class Password{
        private String password;
        public Password() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checked.length; i++) {
                if(checked[i]) sb.append(alphabets[i]);
            }
            password = sb.toString();
        }

        private boolean validation() {
            int mo = 0, ja = 0;
            for (char alphabet : password.toCharArray()) {
                if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') mo++;
                else ja++;
            }

            if(mo < 1 || ja < 2) return false;
            return true;
        }
    }
}