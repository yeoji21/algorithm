package baekjoon.bfs_dfs;

import java.util.*;

public class Main1759 {
    static char[] alphabets;
    static int[] checked;
    static int L, C;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        alphabets = new char[C];
        checked = new int[C];

        for (int i = 0; i < C; i++) {
            alphabets[i] = sc.next().charAt(0);
        }

        Arrays.sort(alphabets);
        new Main1759().solution(0, 0);
    }

    public void solution(int level, int count) {
        if (count == L) {
            StringBuilder pw = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if(checked[i] == 1){
                    pw.append(alphabets[i]);
                }
            }
            if(check(pw.toString().toCharArray()))
                System.out.println(pw);
        }
        else{
            for (int i = level; i < C; i++) {
                checked[i] = 1;
                solution(i + 1, count + 1);
                checked[i] = 0;
            }
        }
    }

    private boolean check(char[] pwd) {
        int mo = 0;
        int ja = 0;
        for (int i = 0; i < L; i++) {
            if(pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u')
                mo ++;
            else ja ++;
        }
        return mo >= 1 && ja >= 2;
    }
}