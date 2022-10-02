package programmers_level2;

public class 문자열_압축 {
    public int solution(String s) {
        int result = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String before = s.substring(0, i);
            String now = "";
            int count = 1;
            StringBuilder sb = new StringBuilder();

            for (int j = i; j <= s.length(); j += i) {
                if(j + i >= s.length())
                    now = s.substring(j, s.length());
                else now = s.substring(j, j + i);

                if(before.equals(now)){
                    count++;
                } else if (count == 1) {
                    sb.append(before);
                    before = now;
                } else {
                    sb.append(count).append(before);
                    before = now;
                    count = 1;
                }
            }
            if(before.length() != i) sb.append(before);

            result = Math.min(result, sb.length());
        }

        return result;
    }

    public int solution2(String s) {
        int answer = s.length();
        for (int gap = 1; gap < s.length() / 2 + 1; gap++) {
            String before = s.substring(0, gap);
            int startIdx = gap;
            int result = 0;
            int count = 1;
            while (startIdx <= s.length()) {
                int endIndex = startIdx + gap;
                if(endIndex > s.length()) endIndex = s.length();
                String substring = s.substring(startIdx, endIndex);
                if(before.equals(substring))
                    count++;
                else{
                    result += gap;
                    result += count == 1 ? 0 : String.valueOf(count).length();
                    count = 1;
                    before = substring;
                }
                startIdx += gap;
            }
            if(before.length() != gap) result += before.length();
            answer = Math.min(answer, result);
        }
        return answer;
    }
}
