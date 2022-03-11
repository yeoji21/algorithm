import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = getIntValue(br);
        nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = getIntValue(br);
        }

        calc(0, Collections.emptyList());
        System.out.println(max);
    }

    private static void calc(int count, List<Integer> list) {
        list.forEach(s -> System.out.print(s + " "));
        System.out.println();
        Integer min = list.stream().min(Comparator.comparing(x -> x)).orElse(0);
        int size = min * list.size();

//        if(size > max){
//            System.out.println("**************************");
//            list.forEach(s -> System.out.print(s + " "));
//            System.out.println(size);
//            System.out.println("**************************");
//        }

        max = Math.max(size, max);
        for (int i = count; i < nums.length; i++) {
            List<Integer> dup = new ArrayList<>(list);
            dup.add(nums[i]);
            calc(i+1, dup);
            calc(i+1, list);
        }

    }

    private static int getIntValue(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}