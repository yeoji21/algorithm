package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main2503 {
    private StringBuilder answer = new StringBuilder();
    /*
    서로 다른 숫자 세 개

    자리와 숫자가 동일하면 스트라이크
    숫자만 맍으면 볼
    3 스트라이크 게임 종료

    내역을 보고 정답이 될 수 있는 수가 총 몇 개인지
     */
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        Hint[] arr = new Hint[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Hint(reader.nextInt(), reader.nextInt(), reader.nextInt());
        }
        solution(arr);
    }

    private void solution(Hint[] arr) {
        int count = 0;

        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                for(int k = 1; k < 10; k++){
                    if(i == k || i == j || j == k) continue;
                    int num = i * 100 + j * 10 + k;

                    boolean flag = true;
                    for(Hint hint : arr){
                        if(calcStrike(hint.num, num) != hint.strike || calcBall(hint.num, num) != hint.ball)
                            flag = false;
                    }
                    if(flag) count++;
                }
            }
        }
        System.out.println(count);
    }

    int calcStrike(int a, int b){
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(a % 10 == b % 10) count++;
            a /= 10;
            b /= 10;
        }
        return count;
    }

    int calcBall(int a, int b){
        int count = 0;
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == j) continue;
                if(aStr.charAt(i) == bStr.charAt(j)) count++;
            }
        }
        return count;
    }


    class Hint{
        int num, strike, ball;

        public Hint(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2503().input(new FastReader());
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
