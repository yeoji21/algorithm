package programmers_level3;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] checked = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if(checked[i]) continue;
            answer++;
            DFS(computers, checked, i);
        }
        return answer;
    }

    private void DFS(int[][] computers, boolean[] checked, int target) {
        checked[target] = true;
        for (int i = 0; i < checked.length; i++) {
            if(i == target || checked[i]) continue;
            if(computers[target][i] == 0) continue;
            DFS(computers, checked, i);
        }
    }
}
