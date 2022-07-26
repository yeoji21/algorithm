package programmers_level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {
    public static void main(String[] args) {
        solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
    }

    public static String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();

        int max = 0;
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

                if (x == (int) x && y == (int) y) {
                    pointList.add(new Point((int) x, (int) y));
                    max = Math.max(max, Math.max((int)x, (int)y));
                }
            }
        }
        int length = max * 2 + 1;

        String[][] result = new String[length][length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], ".");
        }

        pointList.forEach(p -> System.out.println(p.x + " : " + p.y));

        System.out.println("============================================");

        for (int i = 0; i < pointList.size(); i++) {
//            int x = max + pointList.get(i).x;
//            int y = max + pointList.get(i).y;
            int x = pointList.get(i).x;

            if(x < 0) x *= -1;
            else x += max;

            int y = pointList.get(i).y;
            if(y < 0) y *= -1;
            else y += max;

            System.out.println(x + " : " + y);
            result[x][y] = "*";
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

        return new String[]{};
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
