package programmers;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _1차_다트게임 {
    public static void main(String[] args) {
        int solution = solution2("1S2D*3T");
        System.out.println(solution);
    }

    public static int solution2(String dartResult) {
        Pattern pattern = Pattern.compile("([\\d]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        int[] scores = new int[4];
        int idx = 1;

        while (matcher.find()) {
            int score = calculateBonus(matcher.group(2), Integer.parseInt(matcher.group(1)));
            if (matcher.group(3) != null) {
                if(matcher.group(3).equals("*")) {
                    score *= 2;
                    scores[idx-1] *= 2;
                }
                if(matcher.group(3).equals("#")) score *= -1;
            }
            scores[idx++] = score;
        }

        return Arrays.stream(scores).sum();
    }

    private static int calculateBonus(String bonus, int score) {
        if(bonus.equals("D")) return (int) Math.pow(score, 2);
        else if(bonus.equals("T")) return (int) Math.pow(score, 3);
        else return score;
    }


}
