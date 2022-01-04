package hashmapset;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        char[] t = in.readLine().toCharArray();

        new Main4().solution(s, t);
    }

    public void solution(char[] s, char[] t) {
        Map<Character, Integer> targetMap = new HashMap<>();

        int result = 0;

        for (int i = 0; i < t.length; i++) {
            targetMap.put(t[i], targetMap.getOrDefault(t[i], 0) + 1);
        }

        for (int i = 0; i < t.length; i++) {
            targetMap.put(s[i], targetMap.getOrDefault(s[i], 0) - 1);
        }

        int lt = 0, rt = t.length - 1;
        while (lt < rt && rt < s.length) {
            boolean allMatch = targetMap.values().stream().allMatch(x -> x == 0);
            if(allMatch) result++;

            rt++;
            if(rt >= s.length) break;
            targetMap.put(s[rt], targetMap.getOrDefault(s[rt], 0) - 1);

            targetMap.put(s[lt], targetMap.getOrDefault(s[lt], 0) + 1);
            lt++;
        }
        System.out.println(result);
    }
}