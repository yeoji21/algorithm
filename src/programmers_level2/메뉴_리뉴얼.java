package programmers_level2;

import java.util.*;

public class 메뉴_리뉴얼 {
    private static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                combination(orders[j], new boolean[orders[j].length()], course[i], 0);
            }

            if (!map.isEmpty()) {
                int max = map.values().stream().mapToInt(x -> x).max().getAsInt();

                if(max > 1) {
                    map.keySet().stream()
                            .filter(value -> map.get(value) == max)
                            .forEach(result::add);
                }

                map.clear();
            }
        }

        Collections.sort(result);
        return result.toArray(String[]::new);
    }

    private void combination(String target, boolean[] checked, int L, int start) {
        if(target.length() < L) return;
        if (L == 0) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < checked.length; i++) {
                if(checked[i]) sb.append(target.charAt(i));
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        else{
            for (int i = start; i < target.length(); i++) {
                if (!checked[i]) {
                    checked[i] = true;
                    combination(target, checked, L - 1, i + 1);
                    checked[i] = false;
                }
            }
        }
    }
}
