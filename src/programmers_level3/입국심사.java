package programmers_level3;

import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length - 1] * (long)n;
        long answer = 0;
        while(left <= right){
            long mid = (right - left) / 2 + left;
            long sum = 0;
            for(int i = 0; i < times.length; i++){
                sum += mid / times[i];
            }

            if(sum >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return answer;
    }
}
