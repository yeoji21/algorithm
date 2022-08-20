public class Solution {
    public static void main(String[] args) {

    }

    public long solution(int w, int h) {
        long result = 0;

        for (int i = 0; i < w; i++) {
            result += i * (long) h / w;
        }

        return result * 2;
    }
}
