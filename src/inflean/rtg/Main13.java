package inflean.rtg;

import java.util.*;

public class Main13 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }
        new Main13().solution();
    }

    public void solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(graph.get(1));
        int level;
        boolean flag = false;
        for (int target = 2; target <= n; target++) {
            level = 1;
            flag = false;
            queue.clear();
            queue.addAll(graph.get(1));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer removed = queue.remove();
                    if (removed == target) {
                        flag = true;
                        break;
                    }
                    queue.addAll(graph.get(removed));
                }
                if (flag) {
                    System.out.println(target + " : " + level);
                    break;
                }
                level++;
            }
        }
    }
}
