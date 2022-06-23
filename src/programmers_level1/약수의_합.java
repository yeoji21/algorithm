package programmers_level1;

public class 약수의_합 {
    public static void main(String[] args) {
        int solution = solution(3);
        System.out.println(solution);
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n/2; i++){
            if(n%i == 0) answer += i;
        }
        return answer+n;
    }
}
