package programmers_level1;

public class 콜라츠_추측 {
    public int solution(int num) {
        if(num == 1) return 0;

        int count;
        long n = num;
        for (count = 0; count <= 500; count++) {
            if(n == 1) break;
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }

        return n == 1 ? count : -1;
    }
}
