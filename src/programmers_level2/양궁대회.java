package programmers_level2;

import java.util.Arrays;

public class 양궁대회 {
    public static void main(String[] args) {
//        int[] solution = solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        int[] solution = solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        Arrays.stream(solution)
                .forEach(System.out::println);
    }

    // 낮은 점수가 많이 포함된 결과 체크 로직 추가해야 함
    public static int[] solution(int n, int[] info) {
        int maxScore = Integer.MIN_VALUE;
        int[] result = new int[info.length];

        for (int i = 10; i >= 0; i--) {
            int remainArrows = n;
            int[] lion = new int[info.length];
            for (int j = i; j >= 0 && remainArrows > 0; j--) {
                int shot = info[10 - j] + 1;
                if(remainArrows - shot < 0) continue;
                remainArrows -= shot;
                lion[10 - j] = shot;
                if(remainArrows == 0) break;
            }
            int gap = calcScore(lion, info);

            Arrays.stream(lion).forEach(s -> System.out.print(s + " "));
            System.out.println();

            if(gap >= maxScore) {
                boolean flag = true;
//                Arrays.stream(result).forEach(s -> System.out.print(s + " "));
//                System.out.println();
//
//                Arrays.stream(lion).forEach(s -> System.out.println(s + " "));
//                System.out.println();

                if(gap == maxScore) {
                    for (int k = lion.length - 1; k >= 1; k--) {
                        if (lion[k] < result[k]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) continue;
                maxScore = gap;
                result = Arrays.copyOf(lion, lion.length);
            }
        }

        return maxScore == -1 ? new int[]{-1} : result;
    }

    private static int calcScore(int[] lion, int[] apeach) {
        int result = 0;
        for (int i = 0; i < lion.length; i++) {
            int roundPoint = 10 - i;
            if(lion[i] == 0 && apeach[i] == 0) continue;
            if(lion[i] > apeach[i])
                result += roundPoint;
            else
                result -= roundPoint;
        }
        return result;
    }
}
