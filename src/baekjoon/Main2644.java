package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2644 {
    private int answer = - 1;
    private boolean[] checked;
    private List<List<Integer>> family = new ArrayList<>();

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        checked = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            family.add(new ArrayList<>());
        }
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int a = getIntToken(tokenizer);
        int b = getIntToken(tokenizer);
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int p = getIntToken(tokenizer);
            int c = getIntToken(tokenizer);
            family.get(p).add(c);
            family.get(c).add(p);
        }

        find(a, b, 1);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void find(int start, int end, int depth) {
        checked[start] = true;

        for (int i = 0; i < family.get(start).size(); i++) {
            Integer next = family.get(start).get(i);
            if(checked[next]) continue;
            if(next == end) {
                answer = depth;
                return;
            }
            find(next, end, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2644().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
