package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main21314 {
    private StringBuilder answer = new StringBuilder();
    private Map<String, String> maxMap = new HashMap<>();
    private Map<String, String> minMap = new HashMap<>();
    /*
    승수 + 1만큼의 M
    민겸수를 십진수로 바꿨을 때 가장 큰 값과 가장 작은 값
    long으로
     */
    private void input(FastReader reader) throws Exception{
        String s = reader.nextLine();
        solution(s);
    }

    private void solution(String s) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'K'){
                sb.append("K");
                tokens.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append("M");
            }
        }
        if(sb.length() > 0) tokens.add(sb.toString());

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        for(String token : tokens){
            max.append(calcMax(token));
            min.append(calcMin(token));
        }

        answer.append(max).append("\n").append(min);
        System.out.println(answer.toString());
    }

    String calcMax(String token){
        if(maxMap.containsKey(token)) return maxMap.get(token);
        StringBuilder result = new StringBuilder();
        if(token.charAt(token.length() - 1) == 'K'){
            result.append("5");
            result.append("0".repeat(token.length() - 1));
        }else{
            result.append("1".repeat(token.length()));
        }
        maxMap.put(token, result.toString());
        return result.toString();
    }

    String calcMin(String token){
        if(minMap.containsKey(token)) return minMap.get(token);
        StringBuilder result = new StringBuilder();
        if(token.charAt(token.length() - 1) == 'K'){
            if(token.charAt(0) == 'M') {
                result.append("1");
                result.append("0".repeat(token.length() - 2));
            }
            result.append("5");
        }else{
            result.append("1");
            result.append("0".repeat(token.length() - 1));
        }
        minMap.put(token, result.toString());
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        new Main21314().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
