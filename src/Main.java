import java.util.*;

public class Main {
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
        new Main().solution("", 0);
    }

    public void solution(String pw, int i) {
        if (pw.length() == L) {
            if(check(pw.toCharArray())) System.out.println(pw);
            return;
        }
        if(alphabets.length <= i) return;
        solution(pw + alphabets[i], i + 1);
        solution(pw, i+1);
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