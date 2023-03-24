package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Main2412 {
    /*
    n(5만)개의 홈
    x와 y 사이 거리가 각각 2 이하면 홈간 이동 가능
    y = T(20만)일 때까지 등반
    x 좌표는 100만 이하
     */
    private int n, T;
    private Set<Location> set;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        T = reader.nextInt();
        set = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            set.add(new Location(x, y));
        }

        System.out.println(BFS());
    }

    private int BFS() {
        Queue<Location> q = new LinkedList<>();
        q.offer(new Location(0, 0));
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Location location = q.poll();
                if(location.y == T){
                    return count;
                }
                for (int i = -2; i < 3; i++) {
                    for (int j = -2; j < 3; j++) {
                        int nx = location.x + i;
                        int ny = location.y + j;
                        if(!set.contains(new Location(nx, ny))) continue;
                        set.remove(new Location(nx, ny));
                        q.add(new Location(nx, ny));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    class Location{
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x && y == location.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2412().input(new FastReader());
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
