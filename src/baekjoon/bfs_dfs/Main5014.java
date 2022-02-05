package baekjoon.bfs_dfs;

import java.util.*;

public class Main5014 {
    static int F, S, G, U, D;
    static boolean[] checked;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        if(S > G && D <= 0) {
            System.out.println("use the stairs");
            System.exit(0);
        }
        if(S < G && U == 0){
            System.out.println("use the stairs");
            System.exit(0);
        }

        checked = new boolean[F+1];
        System.out.println(new Main5014().solution(S));
    }

    public String solution(int v) {
        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(v, 0));
        checked[v] = true;

        while (!queue.isEmpty()) {
            Floor remove = queue.remove();
            if(remove.floor == G)
                return String.valueOf(remove.count);

            if(!checked[remove.U()]) {
                checked[remove.U()] = true;
                queue.add(new Floor(remove.U(), remove.count + 1));
            }
            if(!checked[remove.D()]) {
                checked[remove.D()] = true;
                queue.add(new Floor(remove.D(), remove.count + 1));
            }
        }

        return "use the stairs";
    }

    static class Floor{
        int floor, count;

        public Floor(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }

        int U(){
            return floor + U <= F ? floor + U : floor;
        }

        int D(){
            return floor - D > 0 ? floor - D : floor;
        }
    }
}
