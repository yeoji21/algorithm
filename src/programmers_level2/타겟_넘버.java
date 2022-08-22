package programmers_level2;

public class 타겟_넘버 {
    static int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return count;
    }

    private void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if(sum == target) count++;
        }
        else{
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            dfs(numbers, depth + 1, target, sum - numbers[depth]);
        }
    }
}
