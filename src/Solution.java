public class Solution {
    public static void main(String[] args) {

    }

    private int answer = 0;
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, numbers[0]);
        return answer;
    }

    private void DFS(int[] numbers, int target, int L, int now) {
        if (L == numbers.length - 1) {
            if(now == target) answer++;
            return;
        }

        DFS(numbers, target, L + 1, now + numbers[L]);
        DFS(numbers, target, L + 1, now - numbers[L]);
    }
}
