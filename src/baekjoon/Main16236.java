package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main16236 {
    /*
    아기상어 크기 2
    자기보다 크기가 큰 물고기 -> 모찌나감
    나머지 -> 지나갈 수 있는데 크기가 같으면 먹지는 못함

    먹을 수 있는 물고기가 1마리 -> 먹으러
    1마리 이상 -> 거리가 가장 가까운 물고기 먹으러
    기까운 물고기가 여러 마리면 가장 위쪽, 그리고 좌측

    아기상어는 자기 크기랑 같은 수의 물고기 먹을 때마다 크기 1 증가

    - 먹을 수 있는 물고기가 있어도 못지나갈 수 있으니 잡아먹고 시간 추가해야 됨
    - 같은 거리 중에서 먹을 수 있는 물고기 모두 찾고 그 중에 하나 선택해야 함
     */
    private int[][] map;
    private int N;
    private Shark shark;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int answer;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        answer = 0;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = getIntToken(tokenizer);
                if(map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new Shark(i, j);
                }
            }
        }

        while(BFS());

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean BFS() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] checked = new boolean[N][N];
        q.add(new int[]{shark.x, shark.y});
        checked[shark.x][shark.y] = true;
        List<int[]> targets = new ArrayList<>();

        int count = 0;
        boolean find = false;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            while (size-- > 0) {
                int[] now = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                    if(checked[nx][ny] || map[nx][ny] > shark.size) continue;
                    checked[nx][ny] = true;

                    if (map[nx][ny] != 0 && map[nx][ny] < shark.size)
                        targets.add(new int[]{nx, ny});
                    else
                        q.add(new int[]{nx, ny});
                }
            }
            if (targets.size() > 0) {
                find = true;
                break;
            }
        }
        if(!find) return false;

        Collections.sort(targets, Comparator.comparing((int[] n) -> n[0]).thenComparing((int[] n) -> n[1]));
        int[] remove = targets.get(0);
        shark.eat(remove);
        map[remove[0]][remove[1]] = 0;
        answer += count;
        return true;
    }

    static class Shark{
        int x, y;
        int size;
        int eaten;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eaten = 0;
        }

        public void eat(int[] fish) {
            this.x = fish[0];
            this.y = fish[1];

            if (++eaten == size) {
                eaten = 0;
                size++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main16236().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}