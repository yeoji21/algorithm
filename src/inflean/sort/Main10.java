package inflean.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10 {
    static int N, C;
    static int[] arr;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        getMinDistance(1, Arrays.stream(arr).max().getAsInt());
        System.out.println(result);
    }

    private static void getMinDistance(int left, int right) {
        if(left > right) return;
        int mid = (left + right) / 2;
        int count = 1;
        int beforeIdx = 0;
        for (int i = 1; i < N; i++) {
            if(arr[i] - arr[beforeIdx] >= mid){
                count++;
                beforeIdx = i;
            }
        }

        if(count < C){
            getMinDistance(left, mid - 1);
        } else {
            result = Math.max(result, mid);
            getMinDistance(mid + 1, right);
        }
    }
}