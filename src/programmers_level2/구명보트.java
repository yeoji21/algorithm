package programmers_level2;

import java.util.Arrays;

public class 구명보트 {
    // 최대 2명이 탈 수 있다는 문제 조건을 제대로 읽지 않음
    public static int solution(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);

        int min = 0;
        for (int max = people.length - 1; min <= max; max--) {
            if(people[min] + people[max] <= limit) min++;
            result++;
        }

        return result;
    }
}
