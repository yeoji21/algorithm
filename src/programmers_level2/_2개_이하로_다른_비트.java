package programmers_level2;

public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
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

    public long[] solution2(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if(number % 2 == 0) answer[i] = number + 1;
            else{
                String binary = Long.toBinaryString(number);
                if(!binary.contains("0")) {
                    binary = binary.replaceFirst("1", "10");
                    answer[i] = Long.parseLong(binary, 2);
                }
                else{
                    int lastZero = binary.lastIndexOf("0");
                    StringBuilder sb = new StringBuilder();
                    sb.append(binary.substring(0, lastZero));
                    sb.append("10");
                    sb.append(binary.substring(lastZero + 2));
                    answer[i] = Long.parseLong(sb.toString(), 2);
                }
            }
        }

        return answer;
    }
}
