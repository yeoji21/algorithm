package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Main16987 {
    private StringBuilder answer = new StringBuilder();
    /*
    틀릴때마다 턱걸이 5회
    계란은 내구도와 무게를 가짐
    계란끼리 치면 상대 계란의 무게만큼 내구도가 깎임
    내구도가 0이 되면 깨짐
    왼쪽부터 차례로 한번씩 쳐서 최대한 많은 계란 깨기
     */
    private int n;
    private Egg[] eggs;
    private boolean[] broken;
    private int max = 0;
    private void input(FastReader reader) throws Exception{
        n = reader.nextIntLine();
        eggs = new Egg[n];
        broken = new boolean[n];
        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(reader.nextInt(), reader.nextInt());
        }

        solution(0);
        System.out.println(max);
    }

    private void solution(int egg) {
        if (egg == n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if(broken[i]) count++;
            }
            max = Math.max(max, count);
            return;
        }
        if(broken[egg]) {
            solution(egg + 1);
            return;
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(egg == i || broken[i]) continue;
            Egg a = eggs[egg];
            Egg b = eggs[i];
            a.defense -= b.weight;
            b.defense -= a.weight;
            if(a.defense <= 0){
                broken[egg] = true;
            }if(b.defense <= 0){
                broken[i] = true;
            }
            flag = true;
            solution(egg + 1);
            a.defense += b.weight;
            b.defense += a.weight;
            broken[egg] = false;
            broken[i] = false;
        }
        if(!flag) solution(egg + 1);
    }

    class Egg{
        int defense;
        int weight;
        boolean broken;

        public Egg(int defense, int weight) {
            this.defense = defense;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main16987().input(new FastReader());
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
