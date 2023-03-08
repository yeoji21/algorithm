package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main9081 {
    private StringBuilder answer = new StringBuilder();
    /*
    주어진 단어로 만들 수 있는 모든 단어 중 해당 단어 다음에 오는 단어
    https://tttuer.tistory.com/212
    https://imgoood.tistory.com/86
     */
    private char[] arr;
    private void input(FastReader reader) throws Exception{
        int n = reader.nextInt();
        while (n-- > 0) {
            String word = reader.nextLine();
            arr = word.toCharArray();
            if(nextPermutation()){
                answer.append(arr).append("\n");
            }else{
                answer.append(word).append("\n");
            }
        }
        System.out.println(answer.toString());
    }

    private boolean nextPermutation() {
        int i = arr.length - 1;
        while(i > 0 && arr[i] <= arr[i - 1]) i--;
        if(i == 0) return false;

        int j = arr.length - 1;
        while(arr[i - 1] >= arr[j]) j--;
        swap(j, i - 1);

        j = arr.length - 1;
        while(j > i){
            swap(i++, j--);
        }
        return true;
    }

    void swap(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        new Main9081().input(new FastReader());
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
