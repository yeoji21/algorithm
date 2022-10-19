package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1700 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);

        tokenizer = new StringTokenizer(br.readLine());
        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = getIntToken(tokenizer);
        }
        boolean[] use = new boolean[101];
        int put = 0;
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int temp = order[i];

            if(use[temp]) continue;
            if(put < N){
                use[temp] = true;
                put++;
            } else{
                List<Integer> list = new ArrayList<>();
                for (int j = i; j < K; j++) {
                    if (use[order[j]] && !list.contains(order[j])) {
                        list.add(order[j]);
                    }
                }

                if (list.size() != N) {
                    for (int j = 0; j < use.length; j++) {
                        if (use[j] && !list.contains(j)) {
                            use[j] = false;
                            break;
                        }
                    }
                }else{
                    Integer remove = list.get(list.size() - 1);
                    use[remove] = false;
                }

                use[temp] = true;
                answer++;
            }

        }
        System.out.println(answer);
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
