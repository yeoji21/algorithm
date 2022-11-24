import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
    뱀 1 사과 3
    오른쪽 1 왼쪽 2
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        map[0][0] = 1;
        int K = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            map[getIntToken(tokenizer) - 1][getIntToken(tokenizer) - 1] = 3;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<int[]> directions = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            directions.add(new int[]{getIntToken(tokenizer), tokenizer.nextToken().equals("D") ? 1 : 2});
        }


    }

    public static void main(String[] args) throws Exception {
        new Main().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}