package programmers_level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄_서는_방법 {
    public static void main(String[] args) {
        int[] solution = solution2(4, 7);
        Arrays.stream(solution)
                .forEach(System.out::print);
        System.out.println();
    }

    public static int[] solution2(int n, long k) {
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>(n * 2);

//        LinkedList 쓰니까 효율성 테스트 통과 못함
//        List<Integer> list = new LinkedList<>();

        long factorial = 1;
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            result[i++] = list.get((int) value);
            list.remove((int) value);
            remain %= factorial;
        }

        return result;
    }


    private static List<int[]> permutations = new ArrayList<>();

    public static int[] solution(int n, long k) {
        int[] people = new int[n];
        for (int i = 0; i < people.length; i++) {
            people[i] = i + 1;
        }

        permutation(people, new int[n] , new boolean[n], n, 0);

        return permutations.get((int)(k - 1));
    }

    private static void permutation(int[] people, int[] pick, boolean[] checked, int n, int depth) {
        if (depth == n) {
            int[] value = new int[n];
            for (int i = 0; i < pick.length; i++) {
                value[i] = pick[i];
            }
            permutations.add(value);

            return;
        }

        for (int i = 0; i < n; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            pick[depth] = people[i];
            permutation(people, pick, checked, n, depth + 1);
            checked[i] = false;
        }
    }
}
