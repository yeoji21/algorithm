package programmers_level2;

import java.util.*;

public class 순위_검색 {
    private Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] result = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            setKeys(infos, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replace(" and ", "").split(" ");
            result[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return result;
    }

    private int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (scores.get(mid) < score) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return scores.size() - start;
    }

    private void setKeys(String[] infos, String key, int L) {
        if (L == 4) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(Integer.valueOf(infos[4]));
        }else{
            setKeys(infos, key + "-", L + 1);
            setKeys(infos, key + infos[L], L + 1);
        }
    }
}
