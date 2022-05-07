import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] count = new int[100_001], before = new int[100_001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        moveToSister();
        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(count[K] - 1 + "\n");

        Stack<Integer> stack = new Stack<>();
        stack.push(K);

        int idx = K;
        while (idx != N) {
            stack.push(before[idx]);
            idx = before[idx];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    private static void moveToSister() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        count[N] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                Integer nowLocation = queue.poll();
                if (nowLocation == K) return;

                for (int way : getThreeWays(nowLocation)) {
                    if (way < 0 || way >= 100_000) continue;

                    if(count[way] == 0) {
                        queue.add(way);
                        count[way] = count[nowLocation]+1;
                        before[way] = nowLocation;
                    }
                }
            }
        }

    }

    private static int[] getThreeWays(int now) {
        int[] ways = new int[3];
        ways[0] = now + 1;
        ways[1] = now - 1;
        ways[2] = now * 2;
        return ways;
    }
}