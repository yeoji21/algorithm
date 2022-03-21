import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[] checked;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getIntToken(st);
        M = getIntToken(st);
        map = new boolean[N + 1][N + 1];
        checked = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = getIntToken(st);
            int y = getIntToken(st);
            map[x][y] = true;
        }

        BFS(1);
        IntStream.range(2, N+1).forEach(i -> System.out.println(i + " : " + distance[i]));
    }

    private static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        checked[n] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (--size >= 0) {
                Integer now = queue.poll();
                for (int i = 1; i < N + 1; i++) {
                    if(map[now][i] && !checked[i]){
                        queue.add(i);
                        checked[i] = true;
                        distance[i] = count;
                    }
                }
            }
        }
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}