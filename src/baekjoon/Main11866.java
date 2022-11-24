package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main11866 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;
            if (count == K) {
                answer.add(poll);
                count = 0;
            } else {
                queue.add(poll);
            }
        }
        System.out.println("<" + answer.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">");
    }

    public static void main(String[] args) throws Exception {
        new Main11866().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
