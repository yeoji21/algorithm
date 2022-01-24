package greedy;

import java.util.*;

public class Main4 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxDay = 0;

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            maxDay = Math.max(day, maxDay);
            meetings.add(new Meeting(pay, day));
        }

        new Main4().solution(meetings, maxDay);
    }

    public void solution(List<Meeting> meetings, int maxDay) {
        meetings.sort(Comparator.comparing(Meeting::getDay));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;

        for (int today = maxDay; today >= 1; today--) {
            for (int j = 0; j < meetings.size(); j++) {
                if(meetings.get(j).day == today) queue.offer(meetings.get(j).pay);
            }

            if(!queue.isEmpty()) {
                sum += queue.poll();
            }
        }

        System.out.println(sum);
    }

    static class Meeting{
        int pay, day;

        public Meeting(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        public int getPay() {
            return pay;
        }

        public int getDay() {
            return -day;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "pay=" + pay +
                    ", day=" + day +
                    '}';
        }
    }

}