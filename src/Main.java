import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] target = Arrays.stream(br.readLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);

        Stack<Integer> stack = new Stack<>();

        int first = Integer.MIN_VALUE;
        int f_idx = -1;
        for (int i = 0; i < K; i++) {
            if(target[i] > first){
                first = target[i];
                f_idx = i;
            }
        }

        K -= f_idx;

        stack.push(target[f_idx]);

        int i = f_idx + 1;
        for (; i < target.length && K > 0; i++) {
            if (stack.peek() < target[i]) {
                stack.pop();
                stack.push(target[i]);
                K--;
            } else {
                stack.push(target[i]);
            }
        }

        if (i < target.length - 1) {
            for (int j = i; j < target.length; j++) {
                stack.push(target[j]);
            }
        }

        stack.forEach(System.out::print);

    }
}