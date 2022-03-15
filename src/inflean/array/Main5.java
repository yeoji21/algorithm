package inflean.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = new int[N + 1];

        for (int i = 2; i < arr.length; i++) {
            if(arr[i] == 0){
                result++;
                for (int j = 2; j*i <= N; j++) {
                    arr[i*j] = 1;
                }
            }
        }
        System.out.println(result);
    }
}
