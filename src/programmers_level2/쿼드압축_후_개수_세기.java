package programmers_level2;

public class 쿼드압축_후_개수_세기 {
    int[] result = new int[2];

    public int[] solution(int[][] arr) {
        recursive(0,0, arr, arr.length);
        return result;
    }

    private void recursive(int startX, int startY, int[][] arr, int n) {
        if (check(startX, startY, arr, n)) {
            result[arr[startX][startY]]++;
            return;
        }

        recursive(startX, startY, arr, n / 2);
        recursive(startX, startY + n / 2, arr, n / 2);
        recursive(startX + n / 2, startY, arr, n / 2);
        recursive(startX + n / 2, startY + n / 2, arr, n / 2);
    }

    private boolean check(int x, int y, int[][] arr, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }

    private int[][] matrix;
    private int[] answer;

    public int[] solution2(int[][] arr) {
        answer = new int[2];
        matrix = arr.clone();
        check(0, arr.length, 0, arr[0].length);
        return answer;
    }

    private void check(int startRow, int endRow, int startColumn, int endColumn ) {
        if(isCheck(startRow, endRow, startColumn, endColumn)) {
            answer[matrix[startRow][startColumn]]++;
            return;
        }

        check(startRow, (startRow + endRow) / 2, startColumn, (startColumn + endColumn) / 2);
        check(startRow, (startRow + endRow) / 2, (startColumn + endColumn) / 2, endColumn);
        check((startRow + endRow) / 2, endRow, startColumn, (startColumn + endColumn) / 2);
        check((startRow + endRow) / 2, endRow, (startColumn + endColumn) / 2, endColumn);
    }

    private boolean isCheck(int startRow, int endRow, int startColumn, int endColumn) {
        for (int i = startRow; i < endRow; i++) {
            for (int j = startColumn; j < endColumn; j++) {
                if(matrix[i][j] != matrix[startRow][startColumn])
                    return false;
            }
        }
        return true;
    }
}
