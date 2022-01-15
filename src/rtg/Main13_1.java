package rtg;

import java.util.*;
import java.util.stream.IntStream;

public class Main13_1 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] checked, distance;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        checked = new int[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }
        new Main13_1().solution();
        IntStream.range(2, n+1).forEach(i ->
        {
            System.out.print(i + " : " + distance[i]);
            System.out.println();
        });
    }

    public void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        checked[1] = 1;
        distance[1] = 0;

        while (!queue.isEmpty()) {
            Integer removed = queue.remove();
            for (Integer next : graph.get(removed)) {
                if (checked[next] == 0) {
                    checked[next] = 1;
                    distance[next] = distance[removed]+1;
                    queue.add(next);
                }
            }
        }
    }
}
