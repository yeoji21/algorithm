package programmers_level2;

public class 타겟_넘버 {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int value, int now) {
        if(now == numbers.length){
            if(value == target) answer++;
            return;
        }

        dfs(numbers, target, value + numbers[now], now + 1);
        dfs(numbers, target, value - numbers[now], now + 1);
    }
}
