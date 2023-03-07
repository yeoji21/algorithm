package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main18311 {
    /*
    코스를 지나서 끝을 찍고 다시 돌아와야 함
    경계인 경우는 앞 숫자
    끝보다 큰 수면 다시 돌아오고 있는 거니까 주의
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = getIntToken(tokenizer);
        long k = Long.parseLong(tokenizer.nextToken());
        long[] arr = new long[n + 1];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + getIntToken(tokenizer);
        }
        solution(arr, k);
    }

    private void solution(long[] arr, long k) {
        if(k == arr[arr.length - 1]){
            System.out.println(arr.length - 2);
        }if(k < arr[arr.length - 1]){
            System.out.println(upperBound(arr, k));
        }else {
            System.out.println(lowerBound(arr, k));
        }
    }

    int upperBound(long[] arr, long k){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] <= k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    int lowerBound(long[] arr, long k){
        long gap = k - arr[arr.length - 1];
        k = arr[arr.length - 1] - gap;

        int left = 0, right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) throws Exception {
        new Main18311().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
