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
        int idx = 0;

        for (long number : numbers) {
            if(number % 2 == 0){
                answer[idx++] = number + 1;
                continue;
            }

            String binary = Long.toBinaryString(number);
            if(!binary.contains("0")){
                binary = binary.replaceFirst("1", "10");
            }else{
                int lastZero = binary.lastIndexOf("0");
                int firstOne = binary.indexOf("1", lastZero);

                StringBuilder sb = new StringBuilder(binary.substring(0, lastZero));
                sb.append("10");
                sb.append(binary.substring(firstOne + 1));
                binary = sb.toString();
            }
            answer[idx++] = Long.parseLong(binary, 2);
        }

        return answer;
    }
}
