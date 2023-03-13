package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main16937 {
    private StringBuilder answer = new StringBuilder();
    /*
    스티커는 90도 회전 가능 -> 우로 회전 좌로 회전 두 가지
    스티커 겹치면 안됨
    최대 크기로 2개 붙이기
     */
    private int h, w;
    private Sticker[] arr;
    private int max = 0;
    private void input(FastReader reader) throws Exception{
        h = reader.nextInt();
        w = reader.nextInt();
        int n = reader.nextIntLine();
        arr = new Sticker[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Sticker(reader.nextInt(), reader.nextInt());
        }
        solution();
    }

    private void solution() {
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                Sticker a = arr[i];
                Sticker b = arr[j];
                if (isFit(a.r, a.c, b.r, b.c) ||
                        isFit(a.c, a.r, b.r, b.c) ||
                        isFit(a.r, a.c, b.c, b.r) ||
                        isFit(a.c, a.r, b.c, b.r)) {
                    max = Math.max(max, a.r * a.c + b.r * b.c);
                }
            }
        }
        System.out.println(max);
    }

    private boolean isFit(int r1, int c1, int r2, int c2) {
        if(r1 + r2 <= h && Math.max(c1, c2) <= w) return true;
        if(Math.max(r1, r2) <= h && c1 + c2 <= w) return true;
        return false;
    }


    class Sticker{
        int r, c;

        public Sticker(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main16937().input(new FastReader());
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
