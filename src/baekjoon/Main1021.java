package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1021 {
    /*
    1. 맨 앞 꺼내기
    2. 왼쪽으로 밀기 -> 커서를 오른쪽으로 이동
    3. 오른쪽으로 밀기 -> 커서를 왼쪽으로 이동
     */

    private int answer = 0;
    private int[] arr;
    private boolean[] checked;
    private int cursor = 0;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int M = getIntToken(tokenizer);
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        checked = new boolean[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            find(getIntToken(tokenizer));
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void find(int target) {
        if(arr[cursor] == target) {
            checked[cursor] = true;
            setNextCursor();
            return;
        }

        int lCursor = cursor;
        int left = 0;
        while (lCursor != target - 1) {
            lCursor = lCursor == arr.length - 1 ? 0 : lCursor + 1;
            if(checked[lCursor]) continue;
            left++;
        }

        int rCursor = cursor;
        int right = 0;
        while (rCursor != target - 1) {
            rCursor = rCursor == 0 ? arr.length - 1 : rCursor - 1;
            if(checked[rCursor]) continue;
            right++;
        }

        cursor = target - 1;
        answer += Math.min(left, right);
        checked[cursor] = true;
        setNextCursor();
    }

    private void setNextCursor() {
        int temp = cursor;
        do {
            cursor = cursor == arr.length - 1 ? 0 : cursor + 1;
            if(temp == cursor) break;
        } while (checked[cursor]);
    }

    public static void main(String[] args) throws Exception {
        new Main1021().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
