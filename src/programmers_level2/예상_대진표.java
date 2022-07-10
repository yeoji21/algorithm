package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 예상_대진표 {
    public static void main(String[] args) {
        int solution = solution(8, 4, 7);
        System.out.println(solution);
    }


    public static int solution(int n, int a, int b) {
        Queue<Participant> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i == a){
                queue.add(new Participant("A", a));
            } else if (i == b) {
                queue.add(new Participant("B", b));
            }else
                queue.add(new Participant("X", i));
        }

        int round = 0;
        while (n > 1) {
            round++;
            n = n / 2;

            for (int i = 1; i < n + 1; i++) {
                Participant red = queue.poll();
                Participant blue = queue.poll();

                if (!red.name.equals("X") || !blue.name.equals("X")) {
                    if (!red.name.equals("X") && !blue.name.equals("X")) {
                        return round;
                    }
                    queue.add(!red.name.equals("X") ? new Participant(red.name, i) : new Participant(blue.name, i));
                } else {
                    queue.add(new Participant("X", i));
                }
            }
        }

        return round;
    }

    static class Participant{
        String name;
        int number;

        public Participant(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }
}
