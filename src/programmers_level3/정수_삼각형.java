package programmers_level3;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int[][] temp = new int[triangle.length][triangle.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = triangle[i].clone();
        }

        for (int i = 0; i < triangle.length - 1; i++) {
            int[] row = triangle[i];
            for (int j = 0; j < row.length; j++) {
                triangle[i + 1][j] = Math.max(temp[i + 1][j] + row[j], triangle[i + 1][j]);
                triangle[i + 1][j + 1] = Math.max(temp[i + 1][j + 1] + row[j], triangle[i + 1][j + 1]);
            }
        }

        int answer = 0;
        for (int value : triangle[triangle.length - 1]) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}