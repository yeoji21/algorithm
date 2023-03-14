package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main9079 {
    private StringBuilder answer = new StringBuilder();
    /*
    H : 앞, T : 뒤
    열, 행, 대각선 하나를 모두 뒤집어야 함
    64?
     */
    private int min = Integer.MAX_VALUE;
    private char[][] map;
    private char[][] temp = new char[3][3];
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        while (n-- > 0) {
            min = Integer.MAX_VALUE;
            map = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = reader.next().charAt(0);
                }
            }
            solution(0, new boolean[8]);
            if(min == Integer.MAX_VALUE) min = -1;
            answer.append(min).append("\n");
        }
        System.out.println(answer.toString());
    }

    private void solution(int start, boolean[] swap) {
        if(start == swap.length){
            flip(swap);
            return;
        }
        for(int i = start; i < 8; i++){
            if(swap[i]) continue;
            swap[i] = true;
            solution(i + 1, swap);
            swap[i] = false;
        }
        solution(8, swap);
    }

    void flip(boolean[] swap){
        copy();

        for(int i = 0; i < 3; i++){
            if(!swap[i]) continue;
            for(int j = 0; j < 3; j++){
                temp[i][j] = toggle(temp[i][j]);
            }
        }
        for(int j = 0; j < 3; j++){
            if(!swap[3 + j]) continue;
            for(int i = 0; i < 3; i++){
                temp[i][j] = toggle(temp[i][j]);
            }
        }
        if(swap[6]){
            temp[0][2] = toggle(temp[0][2]);
            temp[1][1] = toggle(temp[1][1]);
            temp[2][0] = toggle(temp[2][0]);
        }
        if(swap[7]){
            temp[0][0] = toggle(temp[0][0]);
            temp[1][1] = toggle(temp[1][1]);
            temp[2][2] = toggle(temp[2][2]);
        }

        if(check(temp)){
            int count = 0;
            for (int i = 0; i < swap.length; i++) {
                if(swap[i]) count++;
            }
            min = Math.min(min, count);
        }
    }

    private void copy() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                temp[i][j] = map[i][j];
            }
        }
    }

    private boolean check(char[][] temp) {
        char t = temp[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t != temp[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    char toggle(char ch){
        return ch == 'T' ? 'H' : 'T';
    }

    public static void main(String[] args) throws Exception {
        new Main9079().input(new FastReader());
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
