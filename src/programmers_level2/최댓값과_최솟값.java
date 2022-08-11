package programmers_level2;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        int i = Integer.parseInt("-1");
        System.out.println(i);
    }

    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        return min + " " + max;
    }
}
