import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());

        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int num = clone[i];
            int j = i - 1;
            for (; j >= 0 && clone[j] > num; j--) {
                clone[j + 1] = clone[j];
            }
            clone[j + 1] = num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != clone[i]) {
                sb.append((i + 1) + " ");
            }
        }
        System.out.println(sb.toString());
    }
}