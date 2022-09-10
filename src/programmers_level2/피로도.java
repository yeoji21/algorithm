package programmers_level2;

public class 피로도 {
    private int answer = 0;
    private int K;
    public int solution(int k, int[][] dungeons) {
        int size = dungeons.length;
        K = k;
        permutation(dungeons, new boolean[size], new int[size], 0);

        return answer;
    }

    private void permutation(int[][] dungeons, boolean[] checked, int[] selected, int now) {
        if (now == dungeons.length) {
            int fatigue = K;
            int count = 0;
            for (int i = 0; i < selected.length; i++) {
                int required = dungeons[selected[i]][0];
                int reduce = dungeons[selected[i]][1];
                if(fatigue < required) break;
                fatigue -= reduce;
                count++;
            }
            answer = Math.max(answer, count);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            selected[now] = i;
            permutation(dungeons, checked, selected, now + 1);
            checked[i] = false;
        }
    }
}
