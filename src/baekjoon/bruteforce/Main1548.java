package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main1548 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution(arr);
    }

    private void solution(int[] arr) {
        Arrays.sort(arr);
        List<Integer> picked = new LinkedList<>();
        int max = 0;
        for(int num : arr){
            if(picked.size() < 2){
                picked.add(num);
                max = Math.max(max, picked.size());
                continue;
            }
            int sum = picked.get(0) + picked.get(1);
            if(num >= sum){
                while(true){
                    sum -= picked.get(0);
                    picked.remove(0);
                    if(picked.size() == 1) break;
                    sum += picked.get(1);
                    if(sum > num) break;
                }
                picked.add(num);
            }else{
                picked.add(num);
            }
            max = Math.max(max, picked.size());
        }

        System.out.println(max);
    }

    private void solution2(int[] arr) {
        Arrays.sort(arr);

        int result = 1;
        for (int first = 0; first < arr.length - 1; first++) {
            for (int third = arr.length - 1; third >= 0; third--) {
                if(first + 1 == third) break;
                if(arr[first] + arr[first + 1] > arr[third]) {
                    result = Math.max(result, third - first + 1);
                    break;
                }
            }
        }
        if(result == 1 && arr.length >= 2) result = 2;
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main1548().input(new FastReader());
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
