import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> addresses = restoreIpAddresses("101023");
        addresses.forEach(System.out::println);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> answer = new ArrayList<>();
        getIP(answer, s, new int[3], 1, 0);
        return answer;
    }

    static void getIP(List<String> answer, String s, int[] dots, int start, int level){
        if(level == 3){
            int before = 0;
            for(int i = 0; i < 3; i++){
                String num = s.substring(before, dots[i] + 1);
                if(!check(num)) return;
                before = dots[i] + 1;
            }

            StringBuilder ip = new StringBuilder();
            for(int i = 2; i >= 0; i--){
                ip.insert(dots[i] + 1, ".");
            }
            answer.add(ip.toString());

            return;
        }

        for(int i = start; i < s.length() - 1; i++){
            dots[level] = i;
            getIP(answer, s, dots, i + 1, level + 1);
        }
    }

    static boolean check(String num){
        if(num.length() > 1 && num.charAt(0) == '0') return false;
        int sum = 0;
        for(char ch : num.toCharArray()){
            sum = sum * 10 + (ch - '0');
        }
        return sum <= 255;
    }
}