package programmers_level1;

public class 하샤드_수 {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars()
                .map(d -> d - '0')
                .sum();
        return x % sum == 0;
    }
}
