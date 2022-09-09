package programmers_level2;

public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        String target = Integer.toString(n, k);
        int answer = 0;

        for (String number : target.split("0")) {
            if(number.isBlank()) continue;
            if(isPrime(Long.parseLong(number))) answer++;
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if(number == 0 || number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
