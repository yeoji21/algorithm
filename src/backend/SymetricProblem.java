package backend;

import java.io.*;
import java.util.*;

public class SymetricProblem {
    private StringBuilder answer = new StringBuilder();
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        int max = solution("<><??>>");
        System.out.println(max);
    }

    public static int solution(String S) {
        int n = S.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // Try to form a symmetric substring centered at i
            int left = i;
            int right = i + 1;
            int leftCount = 0;
            int rightCount = 0;
            while (left >= 0 && right < n) {
                char leftChar = S.charAt(left);
                char rightChar = S.charAt(right);
                if (leftChar == '<' || leftChar == '?') {
                    leftCount++;
                } else {
                    break;
                }
                if (rightChar == '>' || rightChar == '?') {
                    rightCount++;
                } else {
                    break;
                }
                left--;
                right++;
            }
            // Update maxLen if we found a longer symmetric substring
            if (leftCount == rightCount && leftCount + rightCount > maxLen) {
                maxLen = leftCount + rightCount;
            }
        }
        return maxLen;
    }

//    private static void solution(String s) {
//        check(s, 0, s.length() - 1);
//    }

    private static void check(String s, int start, int end) {
        if(start > end) return;
        int left = start;
        int right = end;

        System.out.println(left + " : " + right);
        int count = 0;
        while (left < right) {
            if((s.charAt(left) == '<' || s.charAt(left) == '?') &&
                    (s.charAt(right) == '>' || s.charAt(right) == '?')){
                count += 2;
                left++;
                right--;
            }else{
                check(s, start + 1, end);
                check(s, start, end - 1);
                return;
            }
        }
        max = Math.max(max, count);
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
