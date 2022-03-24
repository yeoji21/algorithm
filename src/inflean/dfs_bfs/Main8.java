package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main8 {
    static boolean[] checked;
    static int[] selected;
    static int N, F;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        checked = new boolean[N+1];
        selected = new int[N];
        permutation(0);
    }

    private static void permutation(int L) {
        if(flag) return;
        if(L == N){
            if(calc()) {
                Arrays.stream(selected).forEach(num -> System.out.print(num + " "));
                flag = true;
                return;
            }
        }else{
            for (int i = 1; i < N + 1; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    selected[L] = i;
                    permutation(L + 1);
                    checked[i] = false;
                }
            }
        }

    }
    private static boolean calc() {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(selected).forEach(queue::add);

        while (queue.size() != 1) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll() + queue.peek());
            }
            queue.poll();
        }
        return queue.peek() == F;
    }
}