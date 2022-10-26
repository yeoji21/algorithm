package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    private char[][] map;
    private boolean[][] checked;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        map = new char[N][M];
        checked = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = BFS(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        checked[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();

                if(poll[0] == map.length -1 && poll[1] == map[0].length - 1)
                    return count;

                for (int d = 0; d < 4; d++) {
                    int nx = poll[0] + dx[d];
                    int ny = poll[1] + dy[d];

                    if(nx > map.length - 1 || nx < 0 || ny > map[0].length - 1 || ny < 0) continue;
                    if(checked[nx][ny] || map[nx][ny] == '0') continue;

                    checked[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        new Main2178().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}