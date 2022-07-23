package programmers_level2;

import java.util.Arrays;

public class _2개_이하로_다른_비트 {
    public static void main(String[] args) {
        long[] solution = solution2(new long[]{2, 7});
        Arrays.stream(solution).forEach(System.out::println);
    }

    public static long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if(number % 2 == 0) {
                result[i] = number + 1;
                continue;
            }
            String binary = Long.toBinaryString(number);
            int count = 0;
            for (int j = binary.length() - 1; j >= 0; j--, count++) {
                if(binary.charAt(j) == '0') break;
            }
            result[i] = number + (long)(Math.pow(2, (count - 1)));
        }

        return result;
    }

    public static long[] solution2(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if(number % 2 == 0) {
                result[i] = number + 1;
                continue;
            }

            StringBuilder sb = new StringBuilder();
            String binary = Long.toBinaryString(number);

            if (!binary.contains("0")) {
                sb.append("10");
                sb.append(binary.substring(1));
            }
            else{
                int lastZero = binary.lastIndexOf("0");
                int firstOne = binary.indexOf("1", lastZero);

                sb.append(binary.substring(0, lastZero)).append("1").append("0");
                sb.append(binary.substring(firstOne + 1));
            }
            result[i] = Long.parseLong(sb.toString(), 2);
        }

        return result;
    }
}
