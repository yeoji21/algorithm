package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main1022 {
    private StringBuilder answer = new StringBuilder();
    private int[][] map;
    private int top, left, bottom, right;
    private int max = 0;
    private void input(FastReader reader) throws Exception{
        top = reader.nextInt();
        left = reader.nextInt();
        bottom = reader.nextInt();
        right = reader.nextInt();

        map = new int[bottom - top + 1][right - left + 1];
        fill();
        print();
    }

    private int[] dx = {0, -1, 0, 1};
    private int[] dy = {1, 0, -1, 0};

    private void print() {
        int maxLen = (int) Math.log10(max);
        for (int i = 0; i < bottom - top + 1; i++) {
            for (int j = 0; j < right - left + 1; j++) {
                int len = maxLen - (int)Math.log10(map[i][j]);
                for (int k = 0; k < len; k++) {
                    answer.append(" ");
                }
                answer.append(map[i][j] + " ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private void fill() {
        int x = 0, y = 0, dir = 0;
        int num = 1, d = 1, count = 0;

        while(!isFinish()){
            if(x >= top && x <= bottom && y >= left && y <= right){
                map[x - top][y - left] = num;
            }
            num++;
            count++;
            x += dx[dir];
            y += dy[dir];

            if (count == d) {
                count = 0;
                if(dir == 1 || dir == 3) d++;
                dir = (dir + 1) % 4;
            }
        }
        max = num - 1;
    }

    private boolean isFinish() {
        return map[0][0] != 0 && map[bottom - top][0] != 0
                && map[0][right - left] != 0 && map[bottom - top][right - left] != 0;
    }

    private void solution(int top, int bottom, int left, int right) {
        int max = 0;
        int[][] length = new int[map.length][map[0].length];

        for(int i = top; i <= bottom; i++){
            for(int j = left; j <= right; j++){
                int len = String.valueOf(map[i][j]).length();
                length[i][j] = len;
                max = Math.max(max, len);
            }
        }

        for(int i = top; i <= bottom; i++){
            for(int j = left; j <= right; j++){
                if(length[i][j] < max){
                    for(int k = length[i][j]; k < max; k++){
                        answer.append(" ");
                    }
                }
                answer.append(map[i][j] + " ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private void fillMap(int top, int bottom, int left, int right, int num) {
        if(top > bottom || left > right) return;

        for(int j = right; j >= left; j--){
            map[bottom][j] = num--;
        }
        bottom--;
        if(top > bottom || left > right) return;

        for(int i = bottom; i >= top; i--){
            map[i][left] = num--;
        }
        left++;
        if(top > bottom || left > right) return;

        for(int j = left; j <= right; j++){
            map[top][j] = num--;
        }
        top++;
        if(top > bottom || left > right) return;

        for(int i = top; i <= bottom; i++){
            map[i][right] = num--;
        }
        right--;
        if(top > bottom || left > right) return;

        fillMap(top, bottom, left, right, num);
    }


    public static void main(String[] args) throws Exception {
        new Main1022().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
