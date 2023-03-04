package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1913 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        int target = getIntLine(br);
        solution(n, target);
    }

    private void solution(int n, int target) {
        int[][] map = new int[n][n];
        int num = n * n;
        draw(map, num, 0, n - 1, 0, n - 1);

        StringBuilder answer = new StringBuilder();
        int x = - 1, y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == target) {
                    x = i + 1;
                    y = j + 1;
                }
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }
        answer.append(x).append(" ").append(y);
        System.out.println(answer.toString());
    }

    private void draw(int[][] map, int num,
                      int left, int right, int top, int bottom) {
        if(left > right || top > bottom) return;
        for(int i = top; i <= bottom; i++){
            map[i][left] = num--;
        }
        left++;
        if(left > right || top > bottom) return;
        for (int j = left; j <= right; j++) {
            map[bottom][j] = num--;
        }
        bottom--;
        if(left > right || top > bottom) return;
        for (int i = bottom; i >= top; i--) {
            map[i][right] = num--;
        }
        right--;
        if(left > right || top > bottom) return;
        for (int j = right; j >= left; j--) {
            map[top][j] = num--;
        }
        top++;
        draw(map, num, left, right, top, bottom);
    }

    public static void main(String[] args) throws Exception {
        new Main1913().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
