import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int solution = solution("JAN");
        System.out.println(solution);
    }
    private static int answer = Integer.MAX_VALUE;
    public static int solution(String name) {
        boolean[] checked = new boolean[name.length()];
        changeAlphabet(name, checked, 0, 0);
        return answer;
    }

    private static void changeAlphabet(String target, boolean[] checked, int now, int count) {
        if(now > target.length() - 1 || now < 0) return;

        if(checked[now]) return;
        if(target.charAt(now) == 'A'){
            changeAlphabet(target, Arrays.copyOf(checked, checked.length), now + 1, count);
            changeAlphabet(target, Arrays.copyOf(checked, checked.length), now - 1, count);
        }
        char to = target.charAt(now);
        int min = Math.min(Math.abs('A' - to), Math.abs(to - 'Z') + 1);
        checked[now] = true;
        count += min;
        if(over(checked))
            answer = Math.min(answer, count);

        changeAlphabet(target, Arrays.copyOf(checked, checked.length), now + 1, count + 1);
        changeAlphabet(target, Arrays.copyOf(checked, checked.length), now - 1, count + 1);
    }

    private static boolean over(boolean[] checked) {
        for (int i = 0; i < checked.length; i++) {
            if(!checked[i]) return false;
        }
        return true;
    }
}
