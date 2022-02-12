package baekjoon.bfs_dfs;

import java.util.*;

public class Main13913 {
    static int[] checked = new int[100_001];
    static int[] before = new int[100_001];

    static Stack<Integer> stack = new Stack<>();
//    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int dongsang = sc.nextInt();

        jump(subin, dongsang);

        StringBuilder sb = new StringBuilder();
        stack.push(dongsang);

        int index = dongsang;
        while (index != subin) {
            stack.push(before[index]);
            index = before[index];
        }

        System.out.println(checked[dongsang]-1);
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }

    private static void jump(int subin, int dongsang) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);
        checked[subin] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                if(poll == dongsang) return;

                for (int way : jumpToThreeWay(poll)) {
                    if (way < 0 || way > 100_000) continue;

                    if(checked[way] == 0) {
                        queue.add(way);
                        checked[way] = checked[poll]+1;
                        before[way] = poll;
                    }
                }
            }
        }
    }

    private static int[] jumpToThreeWay(Integer poll) {
        int[] results = new int[3];
        results[0] = poll - 1;
        results[1] = poll + 1;
        results[2] = poll * 2;
        return results;
    }
}
