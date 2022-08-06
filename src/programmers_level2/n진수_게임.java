package programmers_level2;

// TODO: 2022/08/05 다른 사람 풀이 보기
public class n진수_게임 {
    public String solution2(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        for (int i = p -1 ; i < m * t; i += m) {
            result.append(sb.charAt(i));
        }

        return result.toString().toUpperCase();
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int index = 1;
        for (int i = 0; i < t * m; i++) {
            String value = conversion(n, i);

            for (int idx = 0; idx < value.length(); idx++, index++) {
                if(index % m == p % m)
                    sb.append(value.charAt(idx));
                if(sb.length() == t)
                    return sb.toString();
            }
        }

        return sb.toString();
    }

    private String conversion(int n, int num) {
        StringBuilder sb = new StringBuilder();

        if(num == 0) return "0";

        while (num >= 0) {
            if(num == 0) break;
            else if(num == 1){
                sb.append(1);
                break;
            }

            int remainder = num % n;
            if (remainder < 10){
                sb.append(remainder);
            }
            else if(remainder == 10){
                sb.append("A");
            } else if (remainder == 11) {
                sb.append("B");
            }else if (remainder == 12) {
                sb.append("C");
            }else if (remainder == 13) {
                sb.append("D");
            }else if (remainder == 14) {
                sb.append("E");
            }else if (remainder == 15) {
                sb.append("F");
            }
            num /= n;
        }

        return sb.reverse().toString();
    }
}
