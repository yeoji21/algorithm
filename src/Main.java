import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            maxDay = Math.max(maxDay, day);
            meetings.add(new Meeting(pay, day));
        }

        new Main().solution(meetings, maxDay);
    }

    public void solution(List<Meeting> meetings, int maxDay) {
        int[] days = new int[maxDay+1];

        meetings.sort(Comparator.comparing(Meeting::getPay).thenComparing(Meeting::getDay).reversed());

        for (Meeting meeting : meetings) {
            int day = meeting.day;
            if (days[day] == 0){
                days[day] = meeting.pay;
            }
            else{
                while(day > 1){
                    day--;
                    if (days[day] == 0){
                        days[day] = meeting.pay;
                    }
                }
            }
        }
//        Arrays.stream(days).forEach(System.out::print);
        System.out.println(Arrays.stream(days).sum());
    }
}

class Meeting{
    int pay, day;

    public Meeting(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    public int getPay() {
        return pay;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "pay=" + pay +
                ", day=" + day +
                '}';
    }
}