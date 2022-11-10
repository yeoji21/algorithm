package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14890 {
    private int N, L;
    private int[][] map;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        L = getIntToken(tokenizer);
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
            }
        }
        int rowCount = rowCheck();
        int columnCount = columnCheck();

        bw.write((rowCount + columnCount) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int columnCheck() {
        boolean[][] checked = new boolean[N][N];
        int answer = 0;

        for (int j = 0; j < N; j++) {
            int height = map[0][j];
            boolean canWork = true;
            for (int i = 1; i < N; i++) {
                if(map[i][j] == height) continue;
                if(Math.abs(map[i][j] - height) >= 2){
                    canWork = false;
                    break;
                }

                if (map[i][j] < height) {
                    int idx = i;
                    int count = 0;
                    boolean ramp = false;
                    while (idx < N && map[idx][j] == map[i][j] && !checked[idx][j]) {
                        checked[idx][j] = true;
                        idx++;
                        count++;
                        if (count == L) {
                            ramp = true;
                            break;
                        }
                    }
                    if(!ramp){
                        canWork = false;
                        break;
                    }
                    i = idx - 1;
                    height -= 1;
                } else if (map[i][j] > height) {
                    int idx = i - 1;
                    int count = 0;
                    boolean ramp = false;
                    while (idx >= 0 && map[idx][j] == map[i - 1][j] && !checked[idx][j]) {
                        checked[idx][j] = true;
                        idx--;
                        count++;
                        if(count == L) {
                            ramp = true;
                            break;
                        }
                    }
                    if(!ramp) {
                        canWork = false;
                        break;
                    }
                    height += 1;
                }
            }
            if(canWork) {
                answer++;
            }
        }
        return answer;
    }

    private int rowCheck() {
        boolean[][] checked = new boolean[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int height = map[i][0];
            boolean canWork = true;
            for (int j = 1; j < N; j++) {
                if(map[i][j] == height) continue;
                if(Math.abs(map[i][j] - height) >= 2){
                    canWork = false;
                    break;
                }
                if(map[i][j] < height){
                    int idx = j;
                    int count = 0;
                    boolean ramp = false;
                    while(idx < N && map[i][idx] == map[i][j] && !checked[i][idx]){
                        checked[i][idx] = true;
                        idx++;
                        count++;
                        if(count == L) {
                            ramp = true;
                            break;
                        }
                    }
                    if(!ramp) {
                        canWork = false;
                        break;
                    }
                    j = idx - 1;
                    height -= 1;
                }
                else if (map[i][j] > height) {
                    height += 1;
                    int idx = j - 1;
                    int count = 0;
                    boolean ramp = false;
                    while (idx >= 0 && map[i][idx] == height - 1 && !checked[i][idx]) {
                        checked[i][idx] = true;
                        idx--;
                        count++;
                        if(count == L) {
                            ramp = true;
                            break;
                        }
                    }
                    if(!ramp) {
                        canWork = false;
                        break;
                    }
                }
            }
            if(canWork) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        new Main14890().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}