package inflean.rtg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main8 {
    static int S, E;
    static boolean[] checked;
    static int[] direction = {1, -1, 5};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        checked = new boolean[10_001];
        BFS(S);
    }

    private static void BFS(int S) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        checked[S] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (--size >= 0) {
                Integer now = queue.poll();
                for (int i = 0; i < 3; i++) {
                    int newDirection = now + direction[i];

                    if(newDirection < 0 || newDirection > 10_000) continue;
                    if(checked[newDirection]) continue;
                    if(newDirection == E) {
                        System.out.println(count);
                        return;
                    }
                    queue.add(newDirection);
                    checked[newDirection] = true;
                }
            }
        }
    }
}