package programmers_level1;

public class 나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        int i = 0;
        for (i = 2; i <= Math.sqrt(n-1); i++) {
            if((n - 1) % i == 0) return i;
        }

        return n-1;
    }
}
