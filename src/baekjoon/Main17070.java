package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main17070 {
    public static void main(String[] args) throws Exception {
        new Main17070().solv();
    }

    private int N;
    private int[][] matrix;
    private int answer;

    public void solv() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = 0;
        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];

        StringTokenizer tokenizer;
        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = getIntToken(tokenizer);
            }
        }

        DFS(1, 2, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void DFS(int x, int y, int d) {
        if (x == N && y == N) {
            answer++;
            return;
        }

        if (d == 0) {
            if(y + 1 <= N && matrix[x][y + 1] == 0)
                DFS(x, y + 1, 0);
        } else if (d == 1) {
            if(x + 1 <= N && matrix[x + 1][y] == 0)
                DFS(x + 1, y, 1);
        } else{
            if(y + 1 <= N && matrix[x][y + 1] == 0)
                DFS(x, y + 1, 0);
            if(x + 1 <= N && matrix[x + 1][y] == 0)
                DFS(x + 1, y, 1);
        }
        if (y + 1 <= N && matrix[x][y + 1] == 0 && x + 1 <= N && matrix[x + 1][y] == 0 && matrix[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, 2);
        }

    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
