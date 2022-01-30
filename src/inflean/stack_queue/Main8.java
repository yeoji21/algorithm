package inflean.stack_queue;

import java.io.*;
import java.util.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nm = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] priority = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main8().solution(nm[0], nm[1], priority);
    }

    public void solution(Integer n, Integer m, Integer[] priority) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.offer(i);

        List<Integer> rank = new ArrayList<>();
        boolean flag = true;

        while (!queue.isEmpty()) {
            Integer seq = queue.remove();
            for (Integer i : queue) {
                if(priority[i] > priority[seq]) {
                    queue.offer(seq);
                    flag = false;
                    break;
                }
            }

            if(flag) {
                rank.add(seq);
                priority[seq] = 0;
            }
            flag = true;
        }

        for (int i = 0; i < rank.size(); i++) {
            if(rank.get(i) == m) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
