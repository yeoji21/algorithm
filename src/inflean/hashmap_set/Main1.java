package inflean.hashmap_set;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<String> votes = Arrays.stream(in.readLine().split("")).collect(Collectors.toList());
        new Main1().solution(votes, n);
    }

    public void solution(List<String> votes, int n) {
        Map<String, Integer> map = new HashMap<>();

        for (String vote : votes) {
            if(!map.containsKey(vote))
                map.put(vote, 1);
            else{
                map.put(vote, map.get(vote) + 1);
            }
        }

        Map.Entry<String, Integer> max = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(max == null || entry.getValue().compareTo(max.getValue())>0){
                max = entry;
            }
        }

        System.out.println(max.getKey());
    }

    public void solution2(List<String> votes, int n) {
        Map<String, Integer> map = new HashMap<>();

        for (String vote : votes)
            map.put(vote, map.getOrDefault(vote, 0)+1);

        String result = "";
        int max = Integer.MIN_VALUE;
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            }
        }

        System.out.println(result);
    }
}
