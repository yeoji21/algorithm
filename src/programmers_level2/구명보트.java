package programmers_level2;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int weight = people[right--];
            if(weight + people[left] <= limit)
                left++;
            answer++;
        }

        return answer;
    }
}
