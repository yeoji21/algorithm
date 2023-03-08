package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main9934 {
    private StringBuilder answer = new StringBuilder();
    /*
    완전 이진 트리의 도시 - 각 빌딩은 번호가 있음
    모든 빌딩에 방문하고 순서 기록
    - 루트에서 출발
    - 왼쪽 자식 방문 시도
    - 오른쪽 자식 방문 시도

    inorder -> level
     */
    private List<Integer>[] level;
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        level = new List[n];
        int[] arr = new int[(int) (Math.pow(2, n) - 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }
        recur(arr, 0, arr.length - 1, 0);

        for (int i = 0; i < level.length; i++) {
            if(level[i] == null) continue;
            for (int value : level[i]) {
                answer.append(value).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private void recur(int[] arr, int left, int right, int depth) {
        if(level[depth] == null) level[depth] = new ArrayList<>();
        if(left == right){
            level[depth].add(arr[left]);
            return;
        }
        int mid = (left + right) / 2;
        level[depth].add(arr[mid]);
        recur(arr, left, mid - 1, depth + 1);
        recur(arr, mid + 1, right, depth + 1);
    }

    public static void main(String[] args) throws Exception {
        new Main9934().input(new FastReader());
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
