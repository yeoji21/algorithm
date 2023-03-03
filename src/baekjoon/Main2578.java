package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2578 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] bingo = new boolean[5][5];
        Map<Integer, int[]> map = new HashMap<>();

        StringTokenizer tokenizer;
        for (int i = 0; i < 5; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map.put(getIntToken(tokenizer), new int[]{i, j});
            }
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                count++;
                int[] point = map.get(getIntToken(tokenizer));
                bingo[point[0]][point[1]] = true;
                if(checkBingo(bingo)){
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    private boolean checkBingo(boolean[][] bingo) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean row = true;
            boolean col = true;
            for (int j = 0; j < 5; j++) {
                if(!bingo[i][j]) row = false;
                if(!bingo[j][i]) col = false;
            }
            if(row) count++;
            if(col) count++;
        }
        if(count >= 3) return true;

        int x = 0, y = 0;
        boolean cross = true;
        for (int i = 1; i < 5; i++) {
            if(!bingo[x][y]) {
                cross = false;
                break;
            }
            x += 1;
            y += 1;
        }
        if(cross && bingo[x][y]) count++;

        x = 4;
        y = 0;
        cross = true;
        for (int i = 1; i < 5; i++) {
            if(!bingo[x][y]) {
                cross = false;
                break;
            }
            x -= 1;
            y += 1;
        }
        if(cross && bingo[x][y]) count++;
        return count >= 3;
    }

    public static void main(String[] args) throws Exception {
        new Main2578().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
