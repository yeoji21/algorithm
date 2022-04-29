package inflean.dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main8 {
    private static int N, F;
    private static int[] result;
    private static boolean[] checked;
    private static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        result = new int[N];
        checked = new boolean[N + 1];

        solution(0);
    }

    private static void solution(int L) {
        if(flag) return;
        if (L == N) {
            if(verify()){
                System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                flag = true;
                return;
            }
        }
        else{
            for (int i = 1; i < N + 1; i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    result[L] = i;
                    solution(L + 1);
                    checked[i] = false;
                }
            }
        }
    }

    private static boolean verify() {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.stream(result).forEach(queue::add);

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