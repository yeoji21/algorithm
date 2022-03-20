package inflean.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9 {
    static int N, M;
    static int[] mugics;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mugics = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) mugics[i] = Integer.parseInt(st.nextToken());

        int left = Arrays.stream(mugics).max().getAsInt();
        int right = Arrays.stream(mugics).sum();
        getRecordSize(left, right);
        System.out.println(result);
    }

    private static void getRecordSize(int left, int right) {
        if(left > right) return;
        int recordSize = (left + right) / 2;
        int nowSize = 0;
        int count = 1;
        for (int i = 0; i < N; i++) {
            nowSize += mugics[i];
            if (nowSize > recordSize) {
                count++;
                nowSize = mugics[i];
            }
        }

        if (count <= M) {
            result = Math.min(result, recordSize);
            getRecordSize(left, recordSize - 1);
        }
        else getRecordSize(recordSize+1, right);
    }
}