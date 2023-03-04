package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main20291 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int n = getIntLine(br);
        while (n-- > 0) {
            String file = br.readLine();
            String extend = findExtend(file);
            map.put(extend, map.getOrDefault(extend, 0) + 1);
        }
        StringBuilder answer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer.append(entry.getKey()).append(" ").append(entry.getValue());
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private String findExtend(String file) {
        for (int i = 0; i < file.length(); i++) {
            if(file.charAt(i) == '.') return file.substring(i + 1);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        new Main20291().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
