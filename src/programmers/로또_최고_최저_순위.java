package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 로또_최고_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] correctLottos = Arrays.stream(lottos).filter(n -> n != 0).toArray();
        int zeroCount = 6 - correctLottos.length;

        List<Integer> winNums = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int minRank = Long.valueOf(Arrays.stream(correctLottos)
                        .filter(winNums::contains)
                        .count())
                .intValue();

        return new int[]{getRank(minRank + zeroCount), getRank(minRank)};
    }

    private int getRank(int rightCount) {
        if(rightCount == 0) return 6;
        return 7 - rightCount;
    }
}
