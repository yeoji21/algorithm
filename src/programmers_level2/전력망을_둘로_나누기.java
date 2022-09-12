package programmers_level2;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int gap = splitGrid(wires, i, n);
            answer = Math.min(answer, gap);
        }

        return answer;
    }

    private int splitGrid(int[][] wires, int excludeIdx, int n) {
        int[] union = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            union[i] = i;
        }

        for (int i = 0; i < wires.length; i++) {
            if(i == excludeIdx) continue;
            int[] wire = wires[i];
            union(union, wire[0], wire[1]);
        }

        int one = 0;
        for (int j = 0; j < n + 1; j++) {
            if(find(union, j) == 1) one++;
        }
        return Math.abs(n - 2 * one);
    }

    private void union(int[] union, int x, int y) {
        int vx = find(union, x);
        int vy = find(union, y);

        if(vx == vy) return;
        if(vx < vy) union[vy] = vx;
        else union[vx] = vy;
    }

    private int find(int[] union, int idx) {
        if(union[idx] == idx) return idx;
        return union[idx] = find(union, union[idx]);
    }
}
