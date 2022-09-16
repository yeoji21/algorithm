package programmers_level2;

import java.util.Arrays;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            String removed = skillTree.replaceAll("[^" + skill + "]", "");
            boolean flag = true;

            for (int j = 0; j < removed.length(); j++) {
                if (removed.charAt(j) != skill.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if(flag) result++;
        }

        return result;
    }

    public int solution2(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
                .filter(skillTree -> skill.startsWith(skillTree.replaceAll("[^" + skill + "]", "")))
                .count();
    }
}
