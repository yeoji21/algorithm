package inflean.rtg;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main6 {
    static int n;
    static int[] ch;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        ch = new int[n + 1];
        new Main6().DFS(1);
    }

    public void DFS(int L) {
        if (L == n + 1) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if(ch[i] == 1) tmp.append(i).append(" ");
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else{
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
}
