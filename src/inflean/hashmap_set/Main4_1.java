package inflean.hashmap_set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main4_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        char[] target = S.toCharArray();
        int lt = 0 , rt = 0;
        Map<Character, Integer> anagram = new HashMap<>();
        while (lt <= rt && rt < target.length) {
            anagram.put(target[rt], anagram.getOrDefault(target[rt], 0) + 1);

            if(rt - lt + 1 == T.length()){
                boolean flag = true;
                for (Character c : map.keySet()) {
                    if (!map.get(c).equals(anagram.get(c))){
                        flag = false;
                        break;
                    }
                }
                if(flag) count++;
                anagram.put(target[lt], anagram.get(target[lt]) - 1);
                lt++;
            }
            rt++;
        }
        System.out.println(count);
    }
}
