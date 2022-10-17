package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int H = getIntToken(tokenizer);
        int W = getIntToken(tokenizer);
        boolean[][] map = new boolean[H][W];
        tokenizer = new StringTokenizer(br.readLine());

        int idx = 0;
        for (int i = 0; i < W; i++) {
            int blocks = getIntToken(tokenizer);
            for (int j = 0; j < blocks; j++) {
                map[H - j - 1][idx] = true;
            }
            idx++;
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j]) {
                    int column = j;
                    while (column + 1 < W && !map[i][++column]) {}
                    if (map[i][column] && column > j) {
                        answer += column - j - 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    // 풀고 다른 풀이 찾아봤는데 이게 더 느림
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int H = getIntToken(tokenizer);
        int W = getIntToken(tokenizer);
        int[] heights = new int[W];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights[i] = getIntToken(tokenizer);
        }

        int answer = 0;
        for (int i = 0; i < W - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, heights[j]);
            }

            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, heights[j]);
            }

            if(heights[i] < left && heights[i] < right)
                answer += Math.min(left, right) - heights[i];
        }
        System.out.println(answer);
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
