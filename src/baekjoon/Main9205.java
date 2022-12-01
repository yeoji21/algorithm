package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main9205 {
    private int[] home;
    private List<int[]> conveniences;
    private boolean[] checked;
    private int[] festival;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());
            tokenizer = new StringTokenizer(br.readLine());
            home = getLocation(tokenizer);
            conveniences = new ArrayList<>(c);
            for (int i = 0; i < c; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                conveniences.add(getLocation(tokenizer));
            }
            checked = new boolean[c];
            tokenizer = new StringTokenizer(br.readLine());
            festival = getLocation(tokenizer);
            answer.append(move(home) ? "happy" : "sad").append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean move(int[] now) {
        if(1000 >= getDistance(now, festival)) return true;

        for (int i = 0; i < conveniences.size(); i++) {
            if (!checked[i] && 1000 >= getDistance(now, conveniences.get(i))) {
                checked[i] = true;
                if(move(conveniences.get(i))) return true;
            }
        }
        return false;
    }

    private int getDistance(int[] start, int[] to) {
        return Math.abs(start[0] - to[0]) + Math.abs(start[1] - to[1]);
    }

    private int[] getLocation(StringTokenizer tokenizer) {
        int[] location = new int[2];
        location[0] = getIntToken(tokenizer);
        location[1] = getIntToken(tokenizer);
        return location;
    }

    public static void main(String[] args) throws Exception {
        new Main9205().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}