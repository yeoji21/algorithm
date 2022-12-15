package programmers_level3;

import java.util.HashSet;
import java.util.Set;

public class 불량_사용자 {
    private boolean[] checked;
    private Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        checked = new boolean[user_id.length];
        DFS(user_id, banned_id, 0);

        return set.size();
    }

    private void DFS(String[] userId, String[] bannedId, int level) {
        if (level == bannedId.length) {
            StringBuilder picked = new StringBuilder();
            for (int i = 0; i < checked.length; i++) {
                if(checked[i]) picked.append(i);
            }
            set.add(picked.toString());
            return;
        }
        String bannedName = bannedId[level];
        int stars = bannedName.length() - bannedName.replace("*", "").length();

        for (int i = 0; i < userId.length; i++) {
            if(checked[i]) continue;
            if(userId[i].length() != bannedName.length()) continue;
            int gap = 0;
            for (int j = 0; j < userId[i].length(); j++) {
                if(userId[i].charAt(j) != bannedName.charAt(j)) gap++;
            }

            if(gap != stars) continue;
            checked[i] = true;
            DFS(userId, bannedId, level + 1);
            checked[i] = false;
        }
    }
}
