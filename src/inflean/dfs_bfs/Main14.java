package inflean.dfs_bfs;

import java.util.*;

public class Main14 {
    static List<Point> house = new ArrayList<>();
    static List<Point> pizza = new ArrayList<>();
    static int result = Integer.MAX_VALUE, m, n;
    static int[] selected;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        selected = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nextInt = sc.nextInt();
                if(nextInt == 1) house.add(new Point(i, j));
                if(nextInt == 2) pizza.add(new Point(i, j));
            }
        }
        new Main14().solution(0, 0);
        System.out.println(result);
    }

    public void solution(int L, int s) {
        if (L == m) {

            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int minLength = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    Point housePoint = house.get(i);
                    Point pizzaPoint = pizza.get(selected[j]);

                    int length = Math.abs(housePoint.x - pizzaPoint.x) + Math.abs(housePoint.y - pizzaPoint.y);
                    minLength = Math.min(length, minLength);
                }
                sum += minLength;
            }
            result = Math.min(sum, result);
        }
        else{
            for (int i = s; i < pizza.size(); i++) {
                selected[L] = i;
                solution(L+1, i+1);
            }
        }
    }
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
