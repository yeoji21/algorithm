package programmers_level2;

import java.util.*;

public class 메뉴_리뉴얼 {
    private int maxCount = 0;
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {
            char[] menus = orders[i].toCharArray();
            Arrays.sort(menus);
            orders[i] = String.valueOf(menus);
        }
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            maxCount = 0;
            for (String order : orders) {
                combination(map, order, new boolean[order.length()], course[i], 0);
            }
            if(maxCount < 2) continue;
            for (String key : map.keySet()) {
                if(map.get(key) == maxCount) answer.add(key);
            }
        }

        return answer.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private void combination(Map<String, Integer> map, String order, boolean[] checked, int L, int start) {
        if (L == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checked.length; i++) {
                if(!checked[i]) continue;
                sb.append(order.charAt(i));
            }
            String menus = sb.toString();
            int count = map.getOrDefault(menus, 0) + 1;
            maxCount = Math.max(maxCount, count);
            map.put(menus, count);
            return;
        }
        for (int i = start; i < checked.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            combination(map, order, checked, L - 1, i + 1);
            checked[i] = false;
        }
    }
}
