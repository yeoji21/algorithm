package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 교점에_별_만들기_답 {
    public String[] solution(int[][] line) {
        String[] result = {};
        List<Point> pointList = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                double x = (B * F - E * D) / (double)(A * D - B * C);
                double y = (E * C - A * F) / (double)(A * D - B * C);

                if (x == (long) x && y == (long) y) {
                    pointList.add(new Point((long) x, (long) y));
                    minX = Math.min(minX, (long) x);
                    maxX = Math.max(maxX, (long) x);
                    minY = Math.min(minY, (long) y);
                    maxY = Math.max(maxY, (long) y);
                }
            }
        }

        boolean[][] resultTemp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (Point point : pointList) {
            int x = (int) (point.x - minX);
            int y = (int) (point.y - maxY);
            resultTemp[Math.abs(y)][Math.abs(x)] = true;
        }

        result = new String[resultTemp.length];

        for (int i = 0; i < resultTemp.length; i++) {
            boolean[] bs = resultTemp[i];
            StringBuilder sb = new StringBuilder();
            for (boolean b : bs) {
                if(b) sb.append("*");
                else sb.append(".");
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

