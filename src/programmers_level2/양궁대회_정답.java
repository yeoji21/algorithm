package programmers_level2;

import java.util.*;

public class 양궁대회_정답 {
    public static void main(String[] args) {
        int[] solution = solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
//        int[] solution = solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1});
        Arrays.stream(solution)
                .forEach(s -> System.out.print(s + " "));
    }
    private static List<int[]> list = new ArrayList<>();
    private static int maxGap = -1;
    private static int[] ryan;
    private static int[] apeach;

    public static int[] solution(int n, int[] info) {
        ryan = new int[info.length];
        apeach = info;

        dfs(n, 0, 0);
        if(maxGap == -1) return new int[]{-1};

        Collections.sort(list, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });

        return list.get(0);
    }

    private static void dfs(int n, int depth, int start) {
        if (depth == n) {
            int apeachSum = 0;
            int ryanSum = 0;

            for (int i = 0; i < 11; i++) {
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] >= ryan[i]) apeachSum += 10 - i;
                else ryanSum += 10 - i;
            }

            if (ryanSum > apeachSum) {
                int gap = ryanSum - apeachSum;
                if (maxGap < gap) {
                    maxGap = gap;
                    list.clear();
                    list.add(ryan.clone());
                } else if (maxGap == gap) {
                    list.add(ryan.clone());
                }
            }

            return;
        }

        for (int i = start; i < 11; i++) {
            ryan[i]++;
            dfs(n, depth + 1, i);
            ryan[i]--;
        }
    }
}
