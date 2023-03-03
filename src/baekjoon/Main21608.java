package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main21608 {
    private int[][] classroom;
    private int[][] nearByEmptyRooms;
    private Map<Integer, Student> seatted;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = getIntLine(br);
        classroom = new int[N][N];
        initializeNearByEmptyRooms(N);
        seatted = new HashMap<>();
        for (int i = 0; i < N * N; i++) {
            Student student = new Student(new StringTokenizer(br.readLine()));
            setLocation(student, N);
        }
        System.out.println(getTotalScore(N));
    }

    private int getTotalScore(int N) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for(int likeNumber : seatted.get(classroom[i][j]).like){
                    Student student = seatted.get(likeNumber);
                    int distance = Math.abs(i - student.x) + Math.abs(j - student.y);
                    if(distance == 1) count++;
                }
                answer += getScoreByCount(count);
            }
        }
        return answer;
    }

    private int getScoreByCount(int count) {
        if(count == 1) return 1;
        else if(count == 2) return 10;
        else if(count == 3) return 100;
        else if(count == 4) return 1000;
        return 0;
    }

    private void setLocation(Student student, int n) {
        int[][] nearByLikedCount = countNearByLiked(student, n);

        int fitX = -1, fitY = -1, maxLike = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(classroom[i][j] != 0) continue;
                // 좋아하는 학생이 근처에 더 많은 경우
                if (nearByLikedCount[i][j] > maxLike) {
                    maxLike = nearByLikedCount[i][j];
                    fitX = i;
                    fitY = j;
                    // 좋아하는 학생이 근처 같은 경우
                } else if (nearByLikedCount[i][j] == maxLike) {
                    if(nearByEmptyRooms[i][j] > nearByEmptyRooms[fitX][fitY]){
                        fitX = i;
                        fitY = j;
                    }
                }
            }
        }
        classroom[fitX][fitY] = student.num;
        student.x = fitX;
        student.y = fitY;
        seatted.put(student.num, student);
        for (int d = 0; d < 4; d++) {
            int nx = fitX + dx[d];
            int ny = fitY + dy[d];
            if(isOutBound(n, nx, ny)) continue;
            nearByEmptyRooms[nx][ny]--;
        }
    }

    private int[][] countNearByLiked(Student student, int n) {
        int[][] nearByLikedCount = new int[n][n];
        for(int likeNumber : student.like){
            if(!seatted.containsKey(likeNumber)) continue;
            Student likedStudent = seatted.get(likeNumber);
            int x = likedStudent.x;
            int y = likedStudent.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(isOutBound(n, nx, ny)) continue;
                nearByLikedCount[nx][ny]++;
            }
        }
        return nearByLikedCount;
    }

    private void initializeNearByEmptyRooms(int n) {
        nearByEmptyRooms = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(isOutBound(n, nx, ny)) continue;
                    count++;
                }
                nearByEmptyRooms[i][j] = count;
            }
        }
    }

    private boolean isOutBound(int n, int nx, int ny) {
        return nx >= n || nx < 0 || ny >= n || ny < 0;
    }

    static class Student{
        int num;
        int x, y;
        int[] like;

        public Student(int num, int[] like) {
            this.num = num;
            this.like = like;
        }

        public Student(StringTokenizer tokenizer) {
            this.num = getIntToken(tokenizer);
            this.like = new int[]{getIntToken(tokenizer), getIntToken(tokenizer), getIntToken(tokenizer), getIntToken(tokenizer)};
        }
    }

    public static void main(String[] args) throws Exception {
        new Main21608().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
