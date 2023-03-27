package baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class Main3151 {
    private StringBuilder answer = new StringBuilder();
    /*
    3명으로 구성된 팀
    코딩 실력(-1만 ~ 1만)
    3명의 코딩 실력의 합이 0이 되는 경우의 수
    팀을 얼마나 많이 만들 수 있는지
     */
    private int n;
    private int[] arr;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }
        solution();
    }

    private void solution() {
        Arrays.sort(arr);
        long count = 0;
        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0){
                    int l = 1;
                    int r = 1;
                    if (arr[left] == arr[right]) {
                        int n = right - left + 1;
                        count += (n * (n - 1) )/ 2;
                        break;
                    }
                    while(arr[left] == arr[left + 1]){
                        l++;
                        left++;
                    }
                    while (arr[right] == arr[right - 1]) {
                        r++;
                        right--;
                    }
                    count += l * r;
                }
                if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main3151().input(new FastReader());
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
