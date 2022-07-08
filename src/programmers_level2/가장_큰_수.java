package programmers_level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 가장_큰_수 {

    public static void main(String[] args) {
        String solution = solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(solution);
    }


    public static String solution(int[] numbers) {
        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return (o2 + o1).compareTo(o1 + o2);
                    }
                })
                .collect(Collectors.joining());
        if(result.charAt(0) == '0') return "0";
        return result;
    }

}
