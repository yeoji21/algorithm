package rtg;

import java.util.*;

public class Main12_1 {
    static int n, m, result = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] checked;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        checked = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }

        checked[1] = 1;
        new Main12_1().solution(1);
        System.out.println(result);
    }

    public void solution(int vertex) {
        if(vertex == n) result++;
        else{
            for (Integer next : graph.get(vertex)) {
                if(checked[next] == 0) {
                    checked[next] = 1;
                    solution(next);
                    checked[next] = 0;
                }
            }
        }
    }
}
