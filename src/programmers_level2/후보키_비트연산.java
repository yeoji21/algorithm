package programmers_level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 후보키_비트연산 {
    public static void main(String[] args) {
        solution(new String[][]{
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}});
    }
    public static int solution(String[][] relation) {
        int rowSize = relation.length;
        int colSize = relation[0].length;

        List<Integer> result = new ArrayList<>();
        System.out.println(1 << colSize);

        for (int i = 1; i < (1 << colSize); i++) {
            if (!isMinimal(i, result)) continue;
            if (!isUnique(i, relation, rowSize, colSize)) continue;

            result.add(i);
        }

        return result.size();
    }

    static boolean isMinimal(int arr, List<Integer> result) {
        for (int key : result) {
            if ((arr & key) == key) {
                return false;
            }
        }
        return true;
    }

    static boolean isUnique(int arr, String[][] relation, int rowSize, int colSize) {
        HashSet<String> set = new HashSet<>();
        String keys = convertToIdx(arr, colSize);

        for (int i = 0; i < rowSize; i++) {
            StringBuilder sb = new StringBuilder();
            for (int key : keys.toCharArray())
                sb.append(relation[i][key - '0']);
            set.add(sb.toString());
        }

        return set.size() == rowSize;
    }

    static String convertToIdx(int arr, int colSize){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < colSize; i++) {
            if (((arr >> i) & 1) == 1) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
