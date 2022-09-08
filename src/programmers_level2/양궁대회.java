package programmers_level2;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class 양궁대회 {
    private Map<Integer, int[]> result;
    public int[] solution(int n, int[] info) {
        result = new TreeMap<>(Comparator.reverseOrder());

        DFS(n, info, new int[info.length], 10);
        if(result.size() == 0)
            return new int[]{-1};

        Map.Entry<Integer, int[]> entry = result.entrySet().iterator().next();
        return result.get(entry.getKey());
    }


    private void DFS(int remain, int[] apeach, int[] lion, int round) {
        if (remain == 0) {
            int gap = calculateGap(apeach, lion);
            if(gap > 0) {
                if(result.containsKey(gap)) {
                    int[] answer = getAnswer(lion, result.get(gap));
                    result.put(gap, answer.clone());
                }
                else
                    result.put(gap, lion.clone());
            }

            return;
        }
        if(round == 0 && remain > 0){
            lion[10] = remain;
            DFS(0, apeach, lion, 0);
            lion[10] = 0;
            return;
        }
        if(round - 1 < 0) return;

        DFS(remain, apeach, lion, round - 1);
        int idx = 10 - round;
        int arrows = apeach[idx] + 1;
        if(remain - arrows >= 0) {
            lion[idx] = arrows;
            DFS(remain - arrows, apeach, lion, round - 1);
            lion[idx] = 0;
        }
    }

    private int[] getAnswer(int[] lion, int[] before) {
        for (int i = lion.length - 1; i >= 0; i--) {
            if(lion[i] == before[i]) continue;

            if(lion[i] > before[i]) return lion;
            else return before;
        }

        return null;
    }

    private int calculateGap(int[] apeach, int[] lion) {
        int apeachScore = 0;
        int lionScore = 0;

        for (int i = 0; i < apeach.length; i++) {
            int score = 10 - i;
            if(apeach[i] == 0 && lion[i] == 0) continue;
            if(apeach[i] >= lion[i])
                apeachScore += score;
            else lionScore += score;
        }

        return lionScore - apeachScore;
    }
}
