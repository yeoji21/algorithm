import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
    1부터 시작하는 NxN
    한 칸에 여러 개 나무 가능

    봄 : 나이만큼 양분먹고 나이 + 1, 나이가 어린 나무부터 양분 먹음, 부족하면 사망
    여름 : 죽은 나무 나이 / 2만큼 양분 추가
    가을 : 나이가 5배수인 나무 인접 8칸에 나이 1인 나무 추가
    겨울 : 양분 추가

    k년이 지난 후 살아있는 나무의 개수는
     */
    private int[][] map;
    private int[][] A;
    private int N, M, K;
    private List<Integer>[][] woods;
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = getIntToken(tokenizer);
        M = getIntToken(tokenizer);
        K = getIntToken(tokenizer);

        map = new int[N][N];
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 5);
        }
        woods = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                woods[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = getIntToken(tokenizer);
            }
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = getIntToken(tokenizer) - 1;
            int y = getIntToken(tokenizer) - 1;
            int age = getIntToken(tokenizer);
            woods[x][y].add(age);
        }

        ageing(K);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += woods[i][j].size();
            }
        }
        System.out.println(answer);
    }

    private void ageing(int years) {
        while (years-- > 0) {
            List<int[]> newWoods = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(woods[i][j].size() == 0) continue;
                    List<Integer> die = new ArrayList<>();
                    spring(i, j, die);
                    summer(i, j, die);
                    fall(newWoods, i, j);
                }
            }
            winter();
            for (int i = 0; i < newWoods.size(); i++) {
                woods[newWoods.get(i)[0]][newWoods.get(i)[1]].add(0, 1);
            }
        }
    }

    private void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    private void fall(List<int[]> newWoods, int i, int j) {
        for (int w = 0; w < woods[i][j].size(); w++) {
            if(woods[i][j].get(w) % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                    newWoods.add(new int[]{nx, ny});
                }
            }
        }
    }

    private void summer(int i, int j, List<Integer> die) {
        for (int w = 0; w < die.size(); w++) {
            map[i][j] += die.get(w) / 2;
        }
    }

    private void spring(int i, int j, List<Integer> die) {
        for (int w = 0; w < woods[i][j].size(); w++) {
            int wood = woods[i][j].get(w);
            if(map[i][j] - wood < 0) {
                woods[i][j].remove(w);
                die.add(wood);
            }
            else{
                map[i][j] -= wood;
                woods[i][j].set(w, wood + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}