package inflean.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = getIntToken(st);
        int M = getIntToken(st);
        int[][] scores = new int[N][M];
        int[] order = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = getIntToken(st) - 1;
                scores[value][i] = j;
                order[j-1] = value;
            }
        }

        int count = 0;

        for (int i = 0; i < order.length; i++) {
            for (int j = i+1; j < order.length; j++) {
                boolean flag = true;
                for (int t = 0; t < M; t++) {
                    if(scores[order[i]][t] > scores[order[j]][t]){
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
            }
        }

        System.out.println(count);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}