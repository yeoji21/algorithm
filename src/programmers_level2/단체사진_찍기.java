package programmers_level2;

public class 단체사진_찍기 {
    static char[] people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int count = 0;
    static char[] selected = new char[8];

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        DFS(0, visited, data);
        return count;
    }

    private static void DFS(int L, boolean[] visited, String[] data) {
        if (L == 8) {
            if(check(selected, data))
                count++;
            return;
        }else{
            for (int i = 0; i < 8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    selected[L] = people[i];
                    DFS(L + 1, visited, data);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean check(char[] selected, String[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < selected.length; i++) {
            sb.append(selected[i]);
        }
        String select = sb.toString();

        for (String condition : data) {
//            int xIdx = findIdx(selected, condition.charAt(0));
//            int yIdx = findIdx(selected, condition.charAt(2));

            int xIdx = select.indexOf(condition.charAt(0));
            int yIdx = select.indexOf(condition.charAt(2));

            int gap = condition.charAt(4) - '0';
            char op = condition.charAt(3);

            if(op == '='){
                if(Math.abs(xIdx - yIdx) != gap+1) return false;
            }
            else if(op == '>'){
                if(!(Math.abs(xIdx - yIdx) > gap+1)) return false;
            }
            else if(op == '<'){
                if(!(Math.abs(xIdx - yIdx) < gap+1)) return false;
            }
        }

        return true;
    }

    private static int findIdx(char[] selected, char target) {
        for (int i = 0; i < selected.length; i++) {
            if(selected[i] == target) return i;
        }
        throw new IllegalArgumentException();
    }
}
