package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        char[] answer = new char[n + 1];

        int carry = 0;
        for(int i = 0; i < answer.length; i++){
            int c1 = i >= a.length() ? 0 : a.charAt(a.length() -1 - i) - '0';
            int c2 = i >= b.length() ? 0 : b.charAt(b.length() -1 - i) - '0';

            char value;
            int sum = carry + c1 + c2;
            if(sum == 3){
                carry = 1;
                value = '1';
            }else if(sum == 2){
                carry = 1;
                value = '0';
            }else if(sum == 1){
                carry = 0;
                value = '1';
            }else{
                carry = 0;
                value = '0';
            }

            answer[answer.length - 1 - i] = value;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(answer));
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
