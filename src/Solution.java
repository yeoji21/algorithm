public class Solution {
    public static void main(String[] args) {
        int solution = solution(2, new String[]{"N~F=0", "R~T>2"});
        System.out.println(solution);
    }

    private static char[] members = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static int result = 0;
    public static int solution(int n, String[] data) {
        char[] selected = new char[8];
        DFS(0, data, selected, new boolean[8]);
        return result;
    }

    private static void DFS(int L, String[] data, char[] selected, boolean[] checked) {
        if (L == 8) {
            if(validate(data, selected))
                result++;
            return;
        }

        for (int i = 0; i < members.length; i++) {
            if(checked[i]) continue;
            checked[i] = true;
            selected[L] = members[i];
            DFS(L + 1, data, selected, checked);
            checked[i] = false;
        }

    }

    private static boolean validate(String[] data, char[] selected) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selected.length; i++) sb.append(selected[i]);
        String select = sb.toString();

        for (String condition : data) {
            int indexA = select.indexOf(condition.charAt(0));
            int indexB = select.indexOf(condition.charAt(2));

            char op = condition.charAt(3);
            int gap = condition.charAt(4) - '0';
            if (op == '=') {
                if(Math.abs(indexA - indexB) != gap + 1)
                    return false;
            } else if (op == '>') {
                if(Math.abs(indexA - indexB) <= gap + 1)
                    return false;
//                if(!(Math.abs(indexA - indexB) > gap+1)) return false;
            } else if (op == '<') {
                if(Math.abs(indexA - indexB) >= gap + 1)
                    return false;
//                if(!(Math.abs(indexA - indexB) < gap+1)) return false;
            }
        }
        return true;
    }
}
