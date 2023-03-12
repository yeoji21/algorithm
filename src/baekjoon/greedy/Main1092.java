package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main1092 {
    private StringBuilder answer = new StringBuilder();

    /*
    n대의 크레인 - 각자 1분에 하나의 박스를 옮길 수 있음
    각 크레인은 무게 제한이 있음
    모든 박스를 옮기는데 드는 최소 시간
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int[] crain = new int[n];
        for (int i = 0; i < crain.length; i++) {
            crain[i] = reader.nextInt();
        }
        int m = reader.nextIntLine();
        int[] containers = new int[m];
        for (int i = 0; i < containers.length; i++) {
            containers[i] = reader.nextInt();
        }

        solution(crain, containers);
    }

    private void solution(int[] crain, int[] containers) {
        Arrays.sort(crain);
        Arrays.sort(containers);
        int count = 0;
        int moved = 0;

        boolean[] checked = new boolean[containers.length];

        while (count < containers.length) {
            int idx = crain.length - 1;
            for (int i = containers.length - 1; i >= 0; i--) {
                if(checked[i]) continue;
                if (idx >= 0 && crain[idx] >= containers[i]) {
                    checked[i] = true;
                    idx--;
                    moved++;
                    if(moved == containers.length) {
                        System.out.println(count + 1);
                        return;
                    }
                }
            }
            count++;
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        new Main1092().input(new FastReader());
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
