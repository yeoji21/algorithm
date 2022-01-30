package inflean.greedy;

import java.util.*;

public class Main3_1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new Meeting(start, "s"));
            meetings.add(new Meeting(end, "e"));
        }

        new Main3_1().solution(meetings);
    }

    public void solution(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(Meeting::getTime).thenComparing(Meeting::getState).reversed());
        int count = 0;
        int result = Integer.MIN_VALUE;
        for (Meeting meeting : meetings) {
            if (meeting.state.equals("e")) {
                count++;
                result = Math.max(count, result);
            } else {
                count--;
            }
        }
        System.out.println(result);
    }

    static class Meeting{
        int time;
        String state;

        public Meeting(int time, String state) {
            this.time = time;
            this.state = state;
        }

        public int getTime() {
            return time;
        }

        public String getState() {
            return state;
        }
    }
}

