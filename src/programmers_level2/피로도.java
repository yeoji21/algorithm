package programmers_level2;

public class 피로도 {
    public static void main(String[] args) {
        int solution = solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(solution);
    }

    static int result = 0;
    static int fatigue;
    public static int solution(int k, int[][] dungeons) {
        fatigue = k;
        boolean[] checked = new boolean[dungeons.length];
        permutation(dungeons, new int[dungeons.length], checked, dungeons.length, 0);

        return result;
    }

    private static void permutation(int[][] dungeons, int[] picked, boolean[] checked, int L, int length) {
        if (length == L) {
            int nowFatigue = fatigue;
            int count = 0;

            for (int i = 0; i < picked.length; i++) {
                int[] dungeon = dungeons[picked[i]];
                if(dungeon[0] > nowFatigue) break;
                nowFatigue -= dungeon[1];
                count++;
            }

            result = Math.max(result, count);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if(checked[i]) continue;

            checked[i] = true;
            picked[length] = i;
            permutation(dungeons, picked, checked, L, length + 1);
            checked[i] = false;
        }
    }
}
