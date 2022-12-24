package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main5052 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            String[] num = new String[N];
            for(int i = 0; i < N; i++){
                num[i] = br.readLine();
            }
            Arrays.sort(num);
            boolean check = false;
            for(int i = 0; i < N - 1; i++){
                if (num[i + 1].startsWith(num[i])) {
                    check = true;
                    break;
                }
            }
            if(check) answer.append("NO");
            else answer.append("YES");
            answer.append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main5052().solv();
    }
}