package baekjoon.bfs_dfs;

import java.util.*;

public class Main9019 {
    static boolean[] memo;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Target> targets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            targets.add(new Target(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < n; i++) {
            new Main9019().solution(targets.get(i));
        }
    }

    public void solution(Target target) {
        memo = new boolean[10_000];

        Queue<Register> queue = new LinkedList<>();
        int goal = target.to;

        queue.add(new Register(target.from, ""));
        memo[target.from] = true;

        while (!queue.isEmpty()) {
            Register remove = queue.poll();

            if(remove.value == goal){
                System.out.println(remove.location);
                break;
            }

            if(!memo[remove.calculateD()]) {
                queue.add(new Register(remove.calculateD(), remove.location + "D"));
                memo[remove.calculateD()] = true;
            }
            if(!memo[remove.calculateS()]) {
                queue.add(new Register(remove.calculateS(), remove.location + "S"));
                memo[remove.calculateS()] = true;
            }
            if(!memo[remove.calculateL()]) {
                queue.add(new Register(remove.calculateL(), remove.location + "L"));
                memo[remove.calculateL()] = true;
            }
            if(!memo[remove.calculateR()]) {
                queue.add(new Register(remove.calculateR(), remove.location + "R"));
                memo[remove.calculateR()] = true;
            }
        }
    }

    static class Register {
        int value;
        String location;

        public Register(int value, String location) {
            this.value = value;
            this.location = location;
        }

        int calculateD() {
            return (value * 2) % 10000;
        }

        int calculateR() {
            return value % 10 * 1000 + value / 10;
        }

        int calculateL() {
            return value % 1000 * 10 + value / 1000;
        }

        int calculateS() {
            return value == 0 ? 9999 : value - 1;
        }

    }


    static class Target{
        int from, to;

        public Target(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
