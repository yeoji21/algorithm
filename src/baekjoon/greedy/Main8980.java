package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main8980 {
    private StringBuilder answer = new StringBuilder();
    /*
    본부에서 출발 1번부터 번호가 붙은 마을들
    박스의 개수 = 트럭의 용량이 정해져 있음
    - 박스는 받는 마을에서만 내릴 수 있음
    - 박스들 중 일부만 배송할 수 있음
     */
    private Box[] boxes;
    private int[] city;
    private int n, c, m;
    private void input(FastReader reader) throws Exception{
        n = reader.nextInt();
        c = reader.nextInt();
        m = reader.nextIntLine();

        city = new int[n];
        boxes = new Box[m];
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(reader.nextInt(), reader.nextInt(), reader.nextInt());
        }

        solution();
    }

    private void solution() {
        Arrays.sort(boxes, Comparator.comparing((Box b) -> b.to).thenComparing(b -> b.from));
        int result = 0;
        for(Box box : boxes){
            int loadable = Integer.MAX_VALUE;
            for(int i = box.from; i < box.to; i++){
                loadable = Math.min(loadable, c - city[i]);
            }

            result += Math.min(loadable, box.count);
            for(int i = box.from; i < box.to; i++){
                city[i] += Math.min(loadable, box.count);
            }
        }
        System.out.println(result);

    }

    class Box{
        int from, to, count;

        public Box(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main8980().input(new FastReader());
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
