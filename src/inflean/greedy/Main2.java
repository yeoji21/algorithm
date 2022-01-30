package inflean.greedy;

import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, end));
        }

        new Main2().solution(meetings);
    }

    public void solution(List<Meeting> meetings) {
        int result = 1;
        meetings.sort(Comparator.comparingInt(Meeting::getEnd).thenComparingInt(Meeting::getStart));
        int limit = meetings.get(0).end;

        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
            if (meeting.start >= limit) {
                result ++;
                limit = meeting.end;
            }
        }

        System.out.println(result);
    }

    static class Meeting{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
