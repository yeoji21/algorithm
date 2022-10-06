package programmers_level2;

import java.util.*;

public class 후보키 {
    private List<String> candidateKeys;

    public int solution(String[][] relation) {
        candidateKeys = new ArrayList<>();
        int columns = relation[0].length;
        if(columns == 1) return 1;

        for (int i = 1; i < columns + 1; i++) {
            combination(relation, new boolean[columns], i, 0);
        }
        return candidateKeys.size();
    }

    private void combination(String[][] relation, boolean[] checked, int level, int start) {
        if (level == 0) {
            String key = getKey(checked);
            if(checkMinimal(key) && checkUnique(relation, checked))
                candidateKeys.add(key);
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            if(checked[i]) continue;

            checked[i] = true;
            combination(relation, checked, level - 1, i + 1);
            checked[i] = false;
        }
    }

    private boolean checkUnique(String[][] relation, boolean[] checked) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < checked.length; j++) {
                if(!checked[j]) continue;
                sb.append(relation[i][j]);
            }
            set.add(sb.toString());
        }

        return set.size() == relation.length;
    }

    private boolean checkMinimal(String key) {
        for (String candidateKey : candidateKeys) {
            int count = 0;
            for (int i = 0; i < candidateKey.length(); i++) {
                if(key.contains(String.valueOf(candidateKey.charAt(i))))
                    count++;
            }
            if(count == candidateKey.length()) return false;
        }
        return true;
    }

    private String getKey(boolean[] checked) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < checked.length; i++) {
            if(checked[i]) sb.append(i);
        }
        return sb.toString();
    }
}
