package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Main1939 {
    private StringBuilder answer = new StringBuilder();
    /*
    n(1만) 개의 섬 사이에 다리 m(10만)개
    한번의 이동에서 옮길 수 있는 중량의 최댓값
    다리 중량은 최대 10억
    다리는 양방향이고, 같은 섬을 잇는 여러 개의 다리 존재 가능
    1-indexed
     */
    private int n, m;
    private List<Bridge>[] b;
    private int start, end;
    private boolean[] checked;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        m = reader.nextInt();
        b = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            b[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            int weight = reader.nextInt();
            b[x].add(new Bridge(y, weight));
            b[y].add(new Bridge(x, weight));
        }
        start = reader.nextInt();
        end = reader.nextInt();
        solution();
    }

    private void solution() {
        int left = 0;
        int right = 1_000_000_001;

        while(left < right){
            int mid = (left + right) / 2;

            if(check(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(right - 1);
    }

    boolean check(int mid){
        checked = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        checked[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == end){
                return true;
            }
            for(Bridge next : b[now]){
                if(next.weight >= mid && !checked[next.to]){
                    checked[next.to] = true;
                    q.add(next.to);
                }
            }
        }
        return false;
    }

    class Bridge{
        int to, weight;

        public Bridge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main1939().input(new FastReader());
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
