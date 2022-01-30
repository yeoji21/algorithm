package inflean.sort;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] xy = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
            points.add(new Point(xy[0], xy[1]));
        }
        new Main7().solution(points);
    }

    public void solution(List<Point> coorList) {
        List<Point> collect = coorList.stream().sorted(Comparator.comparing(Point::getX).thenComparing(Point::getY)).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
