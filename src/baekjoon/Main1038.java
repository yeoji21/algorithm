package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1038 {
    private List<Long> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new Main1038().solution();
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 10){
            System.out.println(n);
            return;
        }

        for (int i = 0; i < 10; i++) {
            DFS(i, 1);
        }
        if(n > answer.size() - 1){
            System.out.println(-1);
            return;
        }
        Collections.sort(answer);
        System.out.println(answer.get(n));
    }

    private void DFS(long num, int idx) {
        if(idx > 10){
            return;
        }
        answer.add(num);

        for (int i = 0; i < num % 10; i++) {
            DFS((num * 10) + i, idx + 1);
        }
    }
}
