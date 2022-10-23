package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3085 {
    private static char[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }
        int answer = 1;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, checkRow(i));
            answer = Math.max(answer, checkColumn(i));
        }
        if(answer == N) {
            System.out.println(N);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j + 1 < N){
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, checkRow(i));
                    answer = Math.max(answer, checkColumn(j));
                    answer = Math.max(answer, checkColumn(j + 1));
                    swap(i, j + 1, i, j);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, checkColumn(j));
                    answer = Math.max(answer, checkRow(i));
                    answer = Math.max(answer, checkRow(i + 1));
                    swap(i + 1, j, i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    private static int checkColumn(int column) {
        int max = 1;
        int count = 1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if(matrix[i][column] == matrix[i+1][column])
                count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    private static int checkRow(int row) {
        int max = 1;
        int count = 1;
        for (int i = 0; i < matrix.length - 1; i++) {
            if(matrix[row][i] == matrix[row][i+1])
                count++;
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
