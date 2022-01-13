package rtg;

import java.io.*;
import java.util.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new Main8().solution(num[0], num[1]);
    }

    public void solution(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        int[] checked = new int[10_001];
        queue.add(s);
        checked[s] = 1;
        int level = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer removed = queue.remove();
                if (removed - 1 == e || removed + 1 == e || removed + 5 == e) {
                    System.out.println(level);
                    return;
                }
                if(removed-1 > 1 && checked[removed-1] == 0) {
                    queue.add(removed - 1);
                    checked[removed - 1] = 1;
                }
                if(checked[removed+1] == 0) {
                    queue.add(removed + 1);
                    checked[removed + 1] = 1;
                }
                if(checked[removed+5] == 0) {
                    queue.add(removed + 5);
                    checked[removed + 5] = 1;
                }
            }
            level++;
        }
    }
}
