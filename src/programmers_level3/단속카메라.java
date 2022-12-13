package programmers_level3;

import java.util.Arrays;

class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int camera = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > camera) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
