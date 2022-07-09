package programmers_level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int[] nums = Arrays.stream(numbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean[] checked = new boolean[numbers.length()];
        recursion(nums, checked, "", 0);
        return set.size();
    }

    private void recursion(int[] nums, boolean[] checked, String sb, int L) {
        if (!sb.equals("")){
            int target = Integer.parseInt(sb);
            if(isPrime(target))
                set.add(target);
        }
        if(L == nums.length) return;
        for (int i = 0; i < nums.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            recursion(nums, checked, sb + nums[i], L+1);
            checked[i] = false;
        }
    }

//    static void dfs(String str, String temp, int m) {
//        if(temp.length() == m){
//            int num = Integer.parseInt(temp);
//            if(!arr.contains(num)){
//                arr.add(num);
//            }
//        }
//
//        for(int i=0; i<str.length(); i++){
//            if(!check[i]){
//                check[i] = true;
//                temp += str.charAt(i);
//                dfs(str, temp, m);
//                check[i] = false;
//                temp = temp.substring(0, temp.length()-1);
//            }
//        }
//    }

    public boolean isPrime(int num){
        if (num == 1 || num == 0) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }
}
