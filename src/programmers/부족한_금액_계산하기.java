package programmers;

public class 부족한_금액_계산하기 {
    public long solution(int price, int money, int count) {

        long total = 0;
        for (int i = 1; i <= count; i++) {
            total += i * price;
        }

        return money >= total ? 0 : total - money;
    }
}
