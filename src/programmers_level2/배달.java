package programmers_level2;

public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(i == j) continue;
                map[i][j] = 500001;
            }
        }

        for (int i = 0; i < road.length; i++) {
            if (map[road[i][0]][road[i][1]] < road[i][2]) continue;
            map[road[i][0]][road[i][1]] = road[i][2];
            map[road[i][1]][road[i][0]] = road[i][2];
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if(i == j) continue;
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < map[1].length; i++) {
            if(map[1][i] <= K) result++;
        }
        return result;
    }
}
