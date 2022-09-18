package programmers_level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total / 3; height++) {
            int width = total / height;
            if(width * height != total) continue;

            int round = height * 2 + width * 2 - 4;
            if (round == brown) return new int[]{width, height};
        }

        return null;
    }
}
