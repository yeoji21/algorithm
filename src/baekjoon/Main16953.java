package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main16953 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int A = getIntToken(tokenizer);
        int B = getIntToken(tokenizer);

        bw.write(BFS(A, B) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS(long a, long b) {
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);
        int count = 0;
        Set<Long> set = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                long poll = queue.poll();
                set.add(poll);
                if(poll == b) {
                    return count;
                }

                if(poll * 2 <= b && !set.contains(poll * 2))
                    queue.add(poll * 2);
                if(poll * 10 + 1 <= b && !set.contains(poll * 10 + 1))
                    queue.add(poll * 10 + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main16953().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
