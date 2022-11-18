package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main16235_v2 {
    private int[][] map;
    private int[][] A;
    private int N, M, K;
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private Deque<Tree> trees = new LinkedList<>();

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
            trees.add(new Tree(x, y, age));
        }

        int year = K;
        while (year-- > 0) {
            springToSummer();
            fall();
            winter();
        }

        bw.write(trees.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void springToSummer() {
        List<Tree> dieTree = new ArrayList<>();
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            if (map[tree.x][tree.y] >= tree.age) {
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                trees.add(tree);
            } else{
                dieTree.add(tree);
            }
        }
        for (Tree removed : dieTree) {
            map[removed.x][removed.y] += removed.age / 2;
        }
    }

    private void fall() {
        List<Tree> parentTree = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                parentTree.add(tree);
            }
        }
        for (Tree tree : parentTree) {
            for (int d = 0; d < 8; d++) {
                int nx = tree.x + dx[d];
                int ny = tree.y + dy[d];
                if (nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                trees.addFirst(new Tree(nx, ny, 1));
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

    static class Tree implements Comparable<Tree>{
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return age - o.age;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main16235_v2().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
