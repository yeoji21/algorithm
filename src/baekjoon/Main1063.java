package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class Main1063 {
    private List<String> commands;
    private int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    private int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    private int[] king;
    private int[] stone;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        commands = List.of("R", "L", "B", "T", "RT", "LT", "RB", "LB");
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        String kingLocation = tokenizer.nextToken();
        king = new int[]{8 - (kingLocation.charAt(1) - '0'), kingLocation.charAt(0) - 'A'};
        String stoneLocation = tokenizer.nextToken();
        stone = new int[]{8 - (stoneLocation.charAt(1) - '0'), stoneLocation.charAt(0) - 'A'};
        int move = getIntToken(tokenizer);

        for (int i = 0; i < move; i++) {
            String command = br.readLine();
            int idx = commands.indexOf(command);
            int nx = king[0] + dx[idx];
            int ny = king[1] + dy[idx];

            if(nx >= 8 || nx < 0 || ny >= 8 || ny < 0) continue;
            if (nx == stone[0] && ny == stone[1]) {
                int snx = stone[0] + dx[idx];
                int sny = stone[1] + dy[idx];

                if(snx >= 8 || snx < 0 || sny >= 8 || sny < 0) {
                    continue;
                }
                stone[0] = snx;
                stone[1] = sny;
            }
            king[0] = nx;
            king[1] = ny;
        }

        StringBuilder answer = new StringBuilder();
        answer.append((char)('A' + king[1])).append(8 - king[0]).append("\n");
        answer.append((char)('A' + stone[1])).append(8 - stone[0]);
        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws Exception {
        new Main1063().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
