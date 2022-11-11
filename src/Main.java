import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    private int[][] map;
    private boolean[][] checked;
    private int N, M;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        map = new int[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = getIntToken(tokenizer);   
            }
        }
        List<CCTV> cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 || map[i][j] == 6) continue;
                cctv.add(new CCTV(i, j));
            }
        }
        Collections.sort(cctv);

        for (int i = 0; i < cctv.size(); i++) {
            CCTV(cctv.get(i).x, cctv.get(i).y);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !checked[i][j]) answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    class CCTV implements Comparable<CCTV>{
        int x, y;

        public CCTV(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(CCTV o) {
            return map[o.x][o.y] - map[this.x][this.y];
        }
    }

    private void CCTV(int x, int y) {
        int[] counts = new int[4];
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            int count = 0;
            while(true) {
                nx += dx[d];
                ny += dy[d];
                if(rangeCheck(nx, ny) || map[nx][ny] == 6) break;
                if(checked[nx][ny]) continue;
                count++;
            }
            counts[d] = count;
        }

        int command = map[x][y];
        if (command == 1) {
            commandOne(x, y, counts);
        } else if (command == 2) {
            commandTwo(x, y, counts);
        } else if (command == 3) {
            commandThree(x, y, counts);
        } else if (command == 4) {
            commandFour(x, y, counts);
        } else {
            for (int i = 0; i < 4; i++) {
                seeing(x, y, i);
            }
        }
    }

    private void commandFour(int x, int y, int[] counts) {
        int d = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 4; i++) {
            if(counts[i] < min){
                min = counts[i];
                d = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if(i == d) continue;
            seeing(x, y, i);
        }
    }

    private void commandThree(int x, int y, int[] counts) {
        int row = 0, column = 2;
        if (counts[0] < counts[1])
            row = 1;
        if (counts[2] < counts[3])
            column = 3;

        seeing(x, y, row);
        seeing(x, y, column);
    }

    private void commandTwo(int x, int y, int[] counts) {
        if (counts[0] + counts[1] >= counts[2] + counts[3]) {
            seeing(x, y, 0);
            seeing(x, y, 1);
        }else{
            seeing(x, y, 2);
            seeing(x, y, 3);
        }
    }

    private void commandOne(int x, int y, int[] counts) {
        int d = -1;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            if(counts[i] > max){
                max = counts[i];
                d = i;
            }
        }
        seeing(x, y, d);
    }

    private void seeing(int x, int y, int d) {
        int nx = x;
        int ny = y;
        while(true){
            nx += dx[d];
            ny += dy[d];
            if(rangeCheck(nx, ny) || map[nx][ny] == 6) break;
            checked[nx][ny] = true;
        }
    }

    private boolean rangeCheck(int nx, int ny) {
        return nx >= N || nx < 0 || ny >= M || ny < 0;
    }

    public static void main(String[] args) throws Exception {
        new Main().solv();
    }
    
    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}