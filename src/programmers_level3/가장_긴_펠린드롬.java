package programmers_level3;

public class 가장_긴_펠린드롬 {
    public int solution(String s){
        for(int i = s.length(); i >= 0; i--){
            for(int j = 0; i + j <= s.length(); j++){
                if(palindrome(s, j, j + i - 1)) return i;
            }
        }
        return 0;
    }

    boolean palindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
