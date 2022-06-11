package programmers;

public class 약수의_개수와_덧셈 {

    public static void main(String[] args) {
    }

    public int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            int count = getDivisorsCount(i);
            result += count % 2 == 0 ? i : -i;
        }

        return result;
    }

    private int getDivisorsCount(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        return count;
    }
}
