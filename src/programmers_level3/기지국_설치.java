package programmers_level3;

public class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int idx = 0;
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (idx < stations.length && i + w >= stations[idx]) {
                i = stations[idx] + w;
                idx++;
            } else{
                i += 2 * w;
                answer++;
            }
        }

        return answer;
    }
}
