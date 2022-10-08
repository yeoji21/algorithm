package programmers_level2;

import java.util.ArrayList;
import java.util.List;

public class 교점에_별_만들기 {
    public String[] solution(int[][] line) {
        List<long[]> stars = new ArrayList<>();
        long minWidth = Long.MAX_VALUE;
        long maxWidth = Long.MIN_VALUE;
        long minHeight = Long.MAX_VALUE;
        long maxHeight = Long.MIN_VALUE;

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
                    long width = (long) x;
                    long height = (long) y;

                    stars.add(new long[]{width, height});
                    minWidth = Math.min(minWidth, width);
                    maxWidth = Math.max(maxWidth, width);
                    minHeight = Math.min(minHeight, height);
                    maxHeight = Math.max(maxHeight, height);
                }
            }
        }

        boolean[][] temp = new boolean[(int) (maxHeight - minHeight + 1)][(int) (maxWidth - minWidth + 1)];

        for (long[] star : stars) {
            int width = Math.abs((int) (maxHeight - star[1]));
            int height = Math.abs((int) (star[0] - minWidth));
            temp[width][height] = true;
        }

        String[] answer = new String[temp.length];
        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (boolean star : temp[i]) {
                if(star) sb.append("*");
                else sb.append(".");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}

