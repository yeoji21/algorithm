package baekjoon.bfs_dfs;

import java.util.*;

public class Main12851 {
    static int[] checked = new int[100_001];
    static int[] distance = new int[100_001];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int dongsang = sc.nextInt();

        jump(subin, dongsang);
    }

    private static void jump(int subin, int dongsang) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);
        checked[subin] = 1;
        int count = 0;

        while (!queue.isEmpty() && checked[dongsang] == 0) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                for (int way : jumpToThreeWay(poll)) {
                    if (way < 0 || way > 100_000) continue;
                    if(checked[way] == 0){
                        queue.add(way);
                        checked[way]++;
                        distance[way] = distance[poll] + 1;
                    } else if (distance[way] == distance[poll] + 1) {
                        queue.add(way);
                        checked[way]++;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(checked[dongsang]);
    }

    private static int[] jumpToThreeWay(Integer poll) {
        int[] results = new int[3];
        results[0] = poll - 1;
        results[1] = poll + 1;
        results[2] = poll * 2;
        return results;
    }
}