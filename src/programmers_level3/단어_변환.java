package programmers_level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        boolean[] checked = new boolean[words.length];
        q.add(begin);
        int answer = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String now = q.poll();
                if(now.equals(target)) return answer;

                for (int i = 0; i < words.length; i++) {
                    if(checked[i]) continue;
                    String word = words[i];
                    int count = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != now.charAt(j)) count++;
                    }
                    if (count != 1) continue;
                    q.add(word);
                    checked[i] = true;
                }
            }
            answer++;
        }

        return 0;
    }
}
