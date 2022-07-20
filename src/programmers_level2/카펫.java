package programmers_level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int totalBlocks = brown + yellow;

        for (int height = 3; height <= totalBlocks / 2; height++) {
            int width = totalBlocks / height;
            if (width * height != totalBlocks) continue;

            int round = width * 2 + height * 2 - 4;
            if(round == brown) return new int[]{width, height};
        }

        return null;
    }
}
