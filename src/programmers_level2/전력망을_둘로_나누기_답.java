package programmers_level2;

public class 전력망을_둘로_나누기_답 {
    private static int[] union;
    public int solution(int n, int[][] wires) {
        int result = 100;

        union = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n + 1; j++) {
                union[j] = j;
            }

            for (int j = 0; j < wires.length; j++) {
                if(i == j) continue;
                int firstNode = wires[j][0];
                int secondNode = wires[j][1];

                union(firstNode, secondNode);
            }

            int one = 0;
            for (int j = 0; j < n + 1; j++) {
                if(find(union[j]) == 1) one++;
            }

            result = Math.min(result, Math.abs(n - 2 * one));
        }

        return result;
    }

    private void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (ry < rx) {
            int temp = rx;
            rx = ry;
            ry = temp;
        }

        if(rx != ry) union[ry] = rx;
    }

    private int find(int x) {
        if(union[x] == x) return x;
        return union[x] = find(union[x]);
    }
}
