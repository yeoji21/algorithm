package programmers_level2;

public class 다음_큰_숫자 {
    public static void main(String[] args) {
        solution(85);
        solution(83);
    }

    public static int solution2(int n) {
        int count = Integer.bitCount(n);

        while (true) {
            if(Integer.bitCount(++n) == count)
                return n;
        }
    }

    public static int solution(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = getCount(binaryString);

        while (true) {
            if(getCount(Integer.toBinaryString(++n)) == count)
                return n;
        }
    }

    private static int getCount(String binaryString) {
        int count = 0;

        for (char c : binaryString.toCharArray()) {
            if(c == '1') count++;
        }

        return count;
    }
}
