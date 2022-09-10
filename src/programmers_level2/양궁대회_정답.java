package programmers_level2;

import java.util.Arrays;

public class 양궁대회_정답 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
    }
    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        int[] tmp = new int[11];
        int maxDiff = 0;

        for (int subset = 1; subset < (1 << 10); subset++) {
            int ryan = 0, apeach = 0, count = 0;
            for (int i = 0; i < 10; i++) {

                if((subset & (1 << i)) != 0){
                    ryan += 10 - i;
                    tmp[i] = info[i] + 1;
                    count += tmp[i];
                }
                else{
                    tmp[i] = 0;
                    if(info[i] > 0) apeach += 10 - i;
                }
            }
            if(count > n) continue;
            tmp[10] = n - count;

            if (ryan - apeach == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if(tmp[i] > answer[i]){
                        maxDiff = ryan - apeach;
                        answer = Arrays.copyOf(tmp, tmp.length);
                        break;
                    } else if(tmp[i] < answer[i])
                        break;
                }
            }
            else if (ryan - apeach > maxDiff) {
                maxDiff = ryan - apeach;
                answer = Arrays.copyOf(tmp, tmp.length);
            }
        }

        if(maxDiff == 0) return new int[]{-1};
        return answer;
    }
}
