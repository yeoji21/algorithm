package programmers;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _1차_비밀지도 {

    public static void main(String[] args) {
        String goal = "0110101011010101101010110101011010101101010";
        String tm = "0000100000000000000000000000000000000000000";

        BigInteger goalInt = new BigInteger(goal, 2);
        BigInteger tmInt = new BigInteger(tm, 2);

        BigInteger and = goalInt.and(tmInt);
        System.out.println(and.bitCount());
        System.out.println(and.toString());

        BigInteger xor = goalInt.xor(tmInt);
        System.out.println(xor.bitCount());
        System.out.println(xor.toString());
    }



    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String binary1 = getBinaryStr(n, arr1[i]);
            String binary2 = getBinaryStr(n, arr2[i]);
            result[i] = mergeMap(n, binary1, binary2);
        }

        return result;
    }

    private static String mergeMap(int n, String binary1, String binary2) {
        return IntStream.range(0, n).mapToObj(idx -> {
                    if (binary1.charAt(idx) == '1' || binary2.charAt(idx) == '1') return "#";
                    else return " ";
                })
                .collect(Collectors.joining());
    }

    private static String getBinaryStr(int n, int array) {
        String binary = Integer.toBinaryString(array);
        if (binary.length() < n) {
            StringBuilder sb = new StringBuilder(binary);
            while(sb.length() < n)
                sb.insert(0, 0);
            return sb.toString();
        }
        return binary;
    }
}
