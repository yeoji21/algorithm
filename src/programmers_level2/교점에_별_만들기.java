package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 교점에_별_만들기 {
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                double x = (b * f - e * d) / (double) (a * d - b * c);
                double y = (e * c - a * f) / (double) (a * d - b * c);

                if (x == (long) x && y == (long) y) {
                    Point point = new Point((long) x, (long) y);
                    points.add(point);
                    minX = Math.min(minX, point.x);
                    maxX = Math.max(maxX, point.x);
                    minY = Math.min(minY, point.y);
                    maxY = Math.max(maxY, point.y);
                }
            }
        }

        boolean[][] temp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (Point point : points) {
            int x = (int) (point.x - minX);
            int y = (int) (maxY - point.y);
            temp[Math.abs(y)][Math.abs(x)] = true;
        }

        String[] answer = new String[temp.length];
        for (int i = 0; i < temp.length; i++) {
            boolean[] row = temp[i];
            StringBuilder sb = new StringBuilder();
            for (boolean isStar : row) {
                if(isStar) sb.append("*");
                else sb.append(".");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    static class Point{
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

