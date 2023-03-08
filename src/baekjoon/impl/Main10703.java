package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main10703 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        int m = reader.nextInt();
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = reader.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);;
            }
        }

        solution(map);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer.append(map[i][j]);
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private void solution(char[][] map) {
        int gap = map.length;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] != 'X') continue;
                int count = 0;
                for(int k = i + 1; k < map.length; k++){
                    if(map[k][j] == '.'){
                        count++;
                    }else if(map[k][j] == '#'){
                        break;
                    }else{
                        count = 0;
                        break;
                    }
                }
                if(count > 0){
                    gap = Math.min(gap, count);
                }
            }
        }

        for(int j = 0; j < map[0].length; j++){
            for(int i = map.length - 1; i >= 0; i--){
                if(map[i][j] == 'X'){
                    char temp = map[i][j];
                    map[i][j] = map[i + gap][j];
                    map[i + gap][j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Main10703().input(new FastReader());
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
