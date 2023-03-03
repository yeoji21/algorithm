package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2470 {
    /*
    산성은 양수, 알칼리성은 음수
    혼합하면 섞은 거의 합
    0에 가장 가까운 혼합액을 만들려고 함
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = getIntLine(br);
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = getIntToken(tokenizer);
        }
        solution(arr);
    }

    private void solution(int[] arr) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int minGap = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;

        while(left < right){
            int sum = arr[right] + arr[left];
            int gap = Math.abs(sum);
            if (gap < minGap) {
                minGap = gap;
                result1 = arr[left];
                result2 = arr[right];
            }
            if(sum > 0) right--;
            else left++;
        }
        System.out.println(result1 + " " + result2);
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws Exception {
        new Main2470().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
