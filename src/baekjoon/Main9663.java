package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main9663 {
    private int answer = 0;
    private int[] selected;
    private int N;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        DFS(0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int level) {
        if (level == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean check = true;
            for (int l = 0; l < level; l++) {
                if(selected[l] == i){
                    check = false;
                    break;
                }
                if (Math.abs(level - l) == Math.abs(selected[l] - i)) {
                    check = false;
                    break;
                }
            }
            if(!check) continue;

            selected[level] = i;
            DFS(level + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main9663().solv();
    }
}
