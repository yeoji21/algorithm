package programmers_level2;

public class 단체사진_찍기 {
    private int answer = 0;
    private char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        permutation(data, new boolean[characters.length], "", 0);
        return answer;
    }

    private void permutation(String[] conditions, boolean[] checked, String selected, int L) {
        if (L == characters.length) {
            if(checkConditions(conditions, selected))
                answer++;
            return;
        }

        for (int i = 0; i < characters.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            permutation(conditions, checked, selected + characters[i], L + 1);
            checked[i] = false;
        }
    }

    private boolean checkConditions(String[] conditions, String selected) {
        for (String condition : conditions) {
            char command = condition.charAt(3);
            int size = condition.charAt(4) - '0';
            int indexA = selected.indexOf(condition.charAt(0));
            int indexB = selected.indexOf(condition.charAt(2));

            if (command == '=') {
                if (Math.abs(indexA - indexB) - 1 != size)
                    return false;
            }
            if (command == '<') {
                if (Math.abs(indexA - indexB) >= size + 1)
                    return false;
            }
            if (command == '>'){
                if(Math.abs(indexA - indexB) <= size + 1)
                    return false;
            }
        }
        return true;
    }
}
