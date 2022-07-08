package programmers_level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class 소수_찾기 {

    public static void main(String[] args) {
        int solution = solution("17");
//        System.out.println(solution);
    }

    static int count = 0;
    static Set<Integer> set = new HashSet<>();

    public static int solution(String numbers) {
        int[] nums = Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] checked = new boolean[numbers.length()];
        String[] selected = new String[numbers.length()];
        permutation(nums, checked, 0, selected);

        set.stream().forEach(System.out::println);
        return set.size();
    }

    private static void permutation(int[] nums, boolean[] checked, int L, String[] selected) {
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                selected[L] = String.valueOf(nums[i]);
                int num = Integer.parseInt(Arrays.stream(selected).filter(Objects::nonNull).collect(Collectors.joining()));
                System.out.println(num);
                if(isPrime(num))
                    set.add(num);
                permutation(nums, checked, L + 1, selected);
                checked[i] = false;
            }
        }
    }

    private static boolean isPrime(int target) {
        if(target == 0 || target == 1) return false;

        boolean[] checked = new boolean[target + 1];

        for (int i = 2; i*i <= target; i++) {
            if (!checked[i]) {
                for (int j = i*i; j <= target; j++) {
                    checked[j] = true;
                }
            }
        }

        return !checked[target];
    }
}
