import java.util.*;

public class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private int maxCount = 0;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int courseCount : course) {
            maxCount = 0;
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String value = new String(chars);
                combi(value, courseCount, 0, new boolean[order.length()]);
            }

            if(map.isEmpty()) continue;
            if(maxCount < 2) continue;
            for (String key : map.keySet()) {
                if(map.get(key) == maxCount) {
                    answer.add(key);
                }
            }
            map.clear();
        }

        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private void combi(String order, int L, int start, boolean[] checked) {
        if (L == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checked.length; i++) {
                if(checked[i]) sb.append(order.charAt(i));
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            maxCount = Math.max(maxCount, map.get(sb.toString()));
            return;
        }

        for (int i = start; i < order.length(); i++) {
            if(checked[i]) continue;
            checked[i] = true;
            combi(order, L - 1, i + 1, checked);
            checked[i] = false;
        }
    }
}
