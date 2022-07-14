package programmers_level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 후보키 {
    public static void main(String[] args) {
        int solution = solution(new String[][]{{"100", "ryan", "music", "2"}
                , {"200", "apeach", "math", "2"}
                , {"300", "tube", "computer", "3"}
                , {"400", "con", "computer", "4"}
                , {"500", "muzi", "music", "3"}
                , {"600", "apeach", "music", "2"}});

//        System.out.println(solution);
    }

    static Map<String, Integer> result = new HashMap<>();

    public static int solution(String[][] relation) {
        int columns = relation[0].length;
        if(columns == 1) return 1;

        boolean[] checked = new boolean[columns];

        for (int i = 1; i < columns; i++) {
            combination("", relation, checked, 0, 0, i);
        }

        return result.keySet().size();
    }

    private static void combination(String key, String[][] relation ,boolean[] checked, int start, int depth, int r) {
        if (depth == r) {

            for (String k : result.keySet()) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String sub = String.valueOf(key.charAt(i));
                    if(k.contains(sub)) count++;
                }
                if(count == k.length()) return;
            }

            Set<String> candidateKey = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuilder value = new StringBuilder();
                for (int j = 0; j < checked.length; j++) {
                    if (checked[j]) {
                        value.append(relation[i][j]);
                    }
                }
                candidateKey.add(value.toString());
            }

            if(candidateKey.size() == relation.length){
                result.put(key, 1);
            }

            return;
        }

        for (int i = start; i < checked.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                combination(key + i, relation, checked, i + 1, depth + 1, r);
                checked[i] = false;
            }
        }
    }
}
