package programmers_level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 후보키 {
    List<String> candi = new ArrayList<>();

    public int solution(String[][] relation) {
        int columns = relation[0].length;
        if(columns == 1) return 1;

        for (int i = 1; i < columns + 1; i++) {
            boolean[] visited = new boolean[columns];
            dfs(visited, 0, 0, i, relation);
        }
        return candi.size();
    }

    public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(i);
                }
            }
            String key = sb.toString();

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                StringBuilder value = new StringBuilder();
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j]) {
                        value.append(relation[i][j]);
                    }
                }
                if(map.containsKey(value.toString())) return;
                else map.put(value.toString(), 0);
            }

            for (String existKey : candi) {
                int count = 0;
                for (int i = 0; i < existKey.length(); i++) {
                    String condition = String.valueOf(existKey.charAt(i));
                    if(key.contains(condition)) count++;
                }
                if(count == existKey.length()) return;
            }
            candi.add(key);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }

    }
}
