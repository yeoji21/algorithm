package programmers_level2;

import java.util.*;

public class 순위_검색 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}
                , new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
        System.out.println("==================");
        Arrays.stream(solution).forEach(System.out::println);
    }

    private static Map<String, List<Integer>> map = new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
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

    private static int binarySearch(String key, int score) {
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

    private static void setKeys(String[] infos, String key, int L) {
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
