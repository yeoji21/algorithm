package programmers_level2;

import java.util.*;
import java.util.stream.Collectors;

public class 괄호_회전하기 {
    public int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.add(ch);
        }
        int anwser = 0;
        int count = 0;
        while (count < s.length()) {
            List<Character> list = new ArrayList<>(queue.size());
            list.addAll(queue);
            if(check(list)) anwser++;

            queue.add(queue.poll());
            count++;
        }

        return anwser;
    }

    private boolean check(List<Character> list) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        Character poll = list.get(idx++);
        if(isCloseCharacter(poll)) return false;
        stack.add(poll);

        while (idx < list.size()) {
            Character ch = list.get(idx++);
            if (isOpenCharacter(ch))
                stack.add(ch);
            else if (isCloseCharacter(ch) && !stack.isEmpty()) {
                if (ch == ')' && stack.peek() == '(') stack.pop();
                else if (ch == '}' && stack.peek() == '{') stack.pop();
                else if (ch == ']' && stack.peek() == '[') stack.pop();
                else return false;
            }
            else return false;
        }

        return stack.size() == 0;
    }

    private boolean isOpenCharacter(Character ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isCloseCharacter(Character poll) {
        return poll == ')' || poll == '}' || poll == ']';
    }


    public static int solution2(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            queue.add(ch);
        }
        int anwser = 0;
        int count = 0;
        while (count < s.length()) {
            String collect = queue.stream().map(String::valueOf)
                    .collect(Collectors.joining());
            if(check(collect)) anwser++;

            queue.add(queue.poll());
            count++;
        }

        return anwser;
    }

    private static boolean check(String target) {
        int before;
        do {
            before = target.length();
            target = target.replace("[]", "");
            target = target.replace("{}", "");
            target = target.replace("()", "");
        } while (before != target.length());

        return target.length() == 0;
    }
}
