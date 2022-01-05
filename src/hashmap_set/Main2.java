package hashmap_set;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr1 = in.readLine().split("");
        String[] strArr2 = in.readLine().split("");
        new Main2().solution(strArr1, strArr2);
    }

    public void solution(String[] strArr1, String[] strArr2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < strArr1.length; i++) {
            map1.put(strArr1[i], map1.getOrDefault(strArr1[i], 0)+1);
            map2.put(strArr2[i], map2.getOrDefault(strArr2[i], 0)+1);
        }

        boolean flag = true;
        for (int i = 0; i < strArr1.length; i++) {
            if (!map1.containsKey(strArr1[i]) || !map2.containsKey(strArr1[i])) {
                flag = false;
                break;
            }
            if (map1.get(strArr1[i]) != map2.get(strArr1[i])) {
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
