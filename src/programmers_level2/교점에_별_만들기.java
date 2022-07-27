package programmers_level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {
    public static void main(String[] args) {
        solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
//        solution(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}});
    }

    public static String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();

        long maxX = 0;
        long maxY = 0;
        for (int i = 0; i < line.length - 1; i++) {
            double A = line[i][0];
            double B = line[i][1];
            double E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];

                double x = (B * F - E * D) / (A * D - B * C);
                double y = (E * C - A * F) / (A * D - B * C);

                if (x == (long) x && y == (long) y) {
                    pointList.add(new Point((long) x, (long) y));
                    maxX = Math.max(maxX, (long)x);
                    maxY = Math.max(maxY, (long)y);
                }
            }
        }
        long lengthX = maxX * 2 + 1;
        long lengthY = maxY * 2 + 1;

        String[][] map = new String[(int)lengthX][(int)lengthY];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], ".");
        }

        long max = 0;
        for (int i = 0; i < pointList.size(); i++) {
            long x = pointList.get(i).y;
            if(x < 0) x *= -2;
            else x = maxX - x;
            max = Math.max(max, x);

            long y = pointList.get(i).x;
            y += maxX;

            map[(int)x][(int)y] = "*";
        }

        String[] result = new String[(int)max + 1];

        for (int i = 0; i < result.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lengthY; j++) {
                sb.append(map[i][j]);
            }
            result[i] = sb.toString();
        }

        return result;
    }

    static class Point{
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
