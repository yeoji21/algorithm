package programmers_level2;

import java.util.*;

public class 후보키 {
    private Set<String> uniqueKeys;
    public int solution(String[][] relation) {
        int columns = relation[0].length;
        if(columns == 1) return 1;

        uniqueKeys = new HashSet<>();
        for (int i = 1; i < columns + 1; i++) {
            combination(relation, new boolean[columns], i, 0);
        }

        return uniqueKeys.size();
    }

    private void combination(String[][] relation, boolean[] checked, int level, int start) {
        if (level == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < checked.length; i++) {
                if(checked[i]) sb.append(i);
            }
            if(keyCheck(sb.toString(), relation))
                uniqueKeys.add(sb.toString());
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            if(checked[i]) continue;

            checked[i] = true;
            combination(relation, checked, level - 1, i);
            checked[i] = false;
        }
    }

    private boolean keyCheck(String key, String[][] relation) {
        for (String uniqueKey : uniqueKeys) {
            int count = 0;
            for (int i = 0; i < uniqueKey.length(); i++) {
                if(key.contains(String.valueOf(uniqueKey.charAt(i))))
                    count++;
            }
            if(count == uniqueKey.length()) return false;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < key.length(); k++) {
                int idx = key.charAt(k) - '0';
                sb.append(relation[i][idx]);
            }
            if(set.contains(sb.toString())) return false;
            set.add(sb.toString());
        }

        return true;
    }
}
