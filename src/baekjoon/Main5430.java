package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main5430 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> q;
        StringTokenizer tokenizer;
        StringBuilder answer = new StringBuilder();

        while(T-- > 0){
            boolean isHeader = true;
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            q = new ArrayDeque<>(N);
            String nums = br.readLine();
            nums = nums.replace("[","").replace("]","");
            tokenizer = new StringTokenizer(nums, ",");
            for(int i = 0; i < N; i++){
                q.add(Integer.parseInt(tokenizer.nextToken()));
            }

            boolean errored = false;
            for(int i = 0; i < command.length(); i++){
                if(command.charAt(i) == 'R')
                    isHeader = !isHeader;
                else{
                    if(q.size() == 0){
                        errored = true;
                        break;
                    }
                    if(isHeader) q.removeFirst();
                    else q.removeLast();
                }
            }

            if(errored) answer.append("error\n");
            else {
                answer.append("[");
                while(!q.isEmpty()) {
                    if (isHeader) answer.append(q.removeFirst());
                    else answer.append(q.removeLast());
                    if(q.size() != 0)
                        answer.append(",");
                }
                answer.append("]");
                answer.append("\n");
            }
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        new Main5430().solv();
    }
}
