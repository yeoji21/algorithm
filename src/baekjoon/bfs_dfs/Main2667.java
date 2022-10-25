package baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2667 {
    private static boolean[][] checked;
    private static int[][] matrix;
    private static int answer = 0;
    private static List<Integer> counts = new ArrayList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        checked = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !checked[i][j]) {
                    BFS(i, j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        Collections.sort(counts);
        for (int i = 0; i < counts.size(); i++) {
            sb.append(counts.get(i)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        answer++;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = poll[0] + dx[d];
                int ny = poll[1] + dy[d];

                if(nx > matrix.length -1 || nx < 0 || ny > matrix.length-1 || ny < 0) continue;
                if(matrix[nx][ny] == 0 || checked[nx][ny]) continue;

                count++;
                checked[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        counts.add(count);
    }
}