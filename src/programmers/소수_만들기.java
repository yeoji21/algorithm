package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 소수_만들기 {
    private static final Map<Integer, Integer> map = getPrimeNumbers();
    private static int[] selected = new int[3];
    private static int result = 0;

    public int solution(int[] nums) {
        findCombinations(nums, 0, 0);
        return result;
    }

    private void findCombinations(int[] nums, int L, int K) {
        if (L == 3) {
            if(map.containsKey(Arrays.stream(selected).sum()))
                result++;
        }else{
            for (int i = K; i < nums.length; i++) {
                selected[L] = nums[i];
                findCombinations(nums, L+1, i + 1);
            }
        }
    }

    public static Map<Integer, Integer> getPrimeNumbers() {
        boolean[] num = new boolean[3000];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i < 3000; i++) {
            if(!num[i]){
                map.put(i, 0);
                for (int j = i; j < num.length; j+=i) {
                    num[j] = true;
                }
            }
        }
        return map;
    }
}
