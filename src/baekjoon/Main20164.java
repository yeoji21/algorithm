package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main20164 {
    /*
    N에 어떤 연산을 거쳐서 최대한 홀수를 많이

    - 수의 각 자리 중 홀수를 카운트
    - 수가 한 자리이면 종료
    - 두 자리면 2개로 나눠서 합을 구하여 새로운 수로 생각
    - 세 자리 이상이면 "임의의 위치"에서 끊어 3개의 수로 분할하고 더하기

    이렇게 만들 수 있는 결과의 최솟값과 최대값을 구하라
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        solution(n);
    }

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private void solution(int n) {
        find(n, 0);
        System.out.println(min + " " + max);
    }

    void find(int n, int sum){
        int count = countOdd(n);

        if(n < 10){
            max = Math.max(max, count + sum);
            min = Math.min(min, count + sum);
        }else if(n < 100){
            find(n / 10 + n % 10, sum + count);
        }else{
            recur(n, 0, 0, sum + count);
        }
    }

    private void recur(int n, int depth, int value, int sum) {
        if(depth == 2){
            find(value + n, sum);
            return;
        }
        int i = 10;
        while(n >= i){
            recur(n / i, depth + 1, value + (n % i), sum);
            i *= 10;
        }
    }

    int countOdd(int n){
        int count = 0;
        while(n > 0){
            if((n % 10) % 2 == 1) count++;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new Main20164().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
