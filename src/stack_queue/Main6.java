package stack_queue;

import java.io.*;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main6().solution(num[0], num[1]);
    }

    public void solution(Integer n, Integer k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            queue.add(i);

        int count = 0;
        while (queue.size() > 1) {
            if (count != k-1) {
                Integer removed = queue.remove();
                queue.add(removed);
                count++;
            }
            else{
                Integer removed = queue.remove();
                count = 0;
            }
        }

        System.out.println(queue.remove());
    }
}