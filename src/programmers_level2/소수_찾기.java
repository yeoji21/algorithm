package programmers_level2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    private Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        String[] splited = numbers.split("");
        permutation(splited, new boolean[splited.length], "");
        return set.size();
    }

    private void permutation(String[] numbers, boolean[] checked, String selected) {
        if(selected.length() > numbers.length) return;

        if(!selected.isBlank() && isPrime(selected))
            set.add(Integer.valueOf(selected));

        for (int i = 0; i < numbers.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            permutation(numbers, checked, selected + numbers[i]);
            checked[i] = false;
        }
    }

    private boolean isPrime(String num) {
        int number = Integer.parseInt(num);
        if(number == 0 || number == 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
