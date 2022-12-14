package programmers_level3;

import java.util.TreeMap;

public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            Integer key = map.higherKey(A[i]);
            if(key == null) key = map.firstKey();

            map.put(key, map.get(key) - 1);
            if(map.get(key) == 0) map.remove(key);
            if(key > A[i]) answer++;
        }

        return answer;
    }
}
