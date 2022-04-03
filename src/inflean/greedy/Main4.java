package inflean.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int lastDay = Integer.MIN_VALUE;

        PriorityQueue<Lecture> queue = new PriorityQueue<>(Comparator.comparing(Lecture::getPay).thenComparing(Lecture::getDay).reversed());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            if(day > lastDay) lastDay = day;
            queue.offer(new Lecture(pay, day - 1));
        }

        int[] lectures = new int[lastDay];

        while (!queue.isEmpty()) {
            Lecture now = queue.poll();
            if(lectures[now.day] == 0)
                lectures[now.day] = now.pay;
            else{
                int tmp = now.day;
                while (--tmp >= 0)
                    if(lectures[tmp] == 0) {
                        lectures[tmp] = now.pay;
                        break;
                    }
            }
        }

        System.out.println(Arrays.stream(lectures).sum());
    }

    static class Lecture{
        int pay, day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        public int getPay() {
            return pay;
        }

        public int getDay() {
            return day;
        }
    }
}