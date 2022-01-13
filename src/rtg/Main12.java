package rtg;

import java.io.*;
import java.util.*;

public class Main12 {
    static int n, m, result = 0;
    static int[][] mat;
    static int[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[0];
        checked = new int[n+1];
        mat = new int[n+1][m+1];

        for (int i = 0; i < nm[1]; i++) {
            int[] points = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mat[points[0]][points[1]] = 1;
        }
        checked[1] = 1;
        new Main12().solution(1);
        System.out.println(result);
    }

    public void solution(int vertex) {
        if (vertex == n) {
            result++;
        }
        else {
            for (int i = 1; i <= n; i++) {
                if (mat[vertex][i] == 1 && checked[i] == 0) {
                    checked[i] = 1;
                    solution(i);
                    checked[i] = 0;
                }
            }
        }
    }
}
