package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main7795 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] a, b;
        StringBuilder result = new StringBuilder();
        while(T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int n = getIntToken(tokenizer);
            int m = getIntToken(tokenizer);
            a = new int[n];
            initialize(a, new StringTokenizer(br.readLine()));
            b = new int[m];
            initialize(b, new StringTokenizer(br.readLine()));
            Arrays.sort(b);
            int count = 0;
            for(int i = 0; i < n; i++){
                count += binarySearch(a[i], b);
            }
            result.append(count + "\n");
        }
        System.out.println(result);
    }

    int binarySearch(int target, int[] arr){
        int left = 0, right = arr.length;
        while(left < right){
            int mid = (right + left) / 2;
            if(arr[mid] >= target) right = mid;
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    void initialize(int[] arr, StringTokenizer tokenizer) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getIntToken(tokenizer);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main7795().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
