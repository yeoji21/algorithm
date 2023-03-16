package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main15686 {
    /*
    NxN - 빈칸, 집, 치킨집
    1-indexed
    치킨 거리 : 집과 가장 가까운 치킨집과의 거리
    도시의 치킨 거리 : 모든 집의 치킨 거리의 합
    치킨 집 중 m개 골라서 도시의 치킨 거리가 최소가 되도록
     */
    private int n, m;
    private int[][] map;
    private List<Location> chickens, houses;
    private int answer = Integer.MAX_VALUE;

    private void input(FastReader reader) throws Exception {
        n = reader.nextInt();
        m = reader.nextInt();
        map = new int[n][n];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
                if(map[i][j] == 1) houses.add(new Location(i, j));
                else if(map[i][j] == 2) chickens.add(new Location(i, j));
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int start, int depth) {
        if(depth == chickens.size() - m){
            calcDistance();
            return;
        }
        for(int i = start; i < chickens.size(); i++){
            Location location = chickens.get(i);
            map[location.x][location.y] = 0;
            DFS(i + 1, depth + 1);
            map[location.x][location.y] = 2;
        }

    }

    void calcDistance(){
        int sum = 0;
        for(Location location : houses){
            int distance = Integer.MAX_VALUE;
            for (Location chicken : chickens) {
                if(map[chicken.x][chicken.y] == 0) continue;
                distance = Math.min(distance, Math.abs(location.x - chicken.x) + Math.abs(location.y - chicken.y));
            }
            sum += distance;
        }
        answer = Math.min(answer, sum);
    }

    class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main15686().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
