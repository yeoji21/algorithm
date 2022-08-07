package programmers_level2;

public class k진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
//        int solution = solution(437674, 3);
        int solution = solution(999_999, 5);
        System.out.println(solution);
    }

    public static int solution(int n, int k) {
        int result = 0;
        String target = Integer.toString(n, k);
        for (String num : target.split("0")) {
            if(num.equals("")) continue;
            if(isPrime(num)) result++;
        }

        return result;
    }

    private static boolean isPrime(String num) {
        long value = Long.parseLong(num);
        if(value == 1) return false;

        for (int i = 2; i <= Math.sqrt(value); i++) {
            if(value % i == 0) return false;
        }

        return true;
    }
}
