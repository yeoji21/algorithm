package programmers_level3;

public class 추석_트래픽 {
    public static void main(String[] args) {
        int solution = solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"});

        System.out.println(solution);
    }


    // https://mishuni.tistory.com/125
    // https://ckddn9496.tistory.com/74
    // https://geunzrial.tistory.com/26
    public static int solution(String[] lines) {
        int result = 0;

        int[] starts = new int[lines.length];
        int[] ends = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] logs = line.split(" ");
            String[] date = logs[1].split(":");
            int endMs = getMilliSeconds(date);
            int startMs = endMs - (int)(Double.parseDouble(logs[2].replace("s", "")) * 1000) + 1;
            ends[i] = endMs;
            starts[i] = startMs;
        }

        for (int i = 0; i < starts.length; i++) {
            int endMs = ends[i];
            int maxStartMs = endMs + 1000;
            int count = 1;

            for (int j = i + 1; j < starts.length; j++) {
                if(starts[j] < maxStartMs) count++;
            }
            result = Math.max(result, count);
        }

        return result;
    }

    private static int getMilliSeconds(String[] date) {
        return Integer.parseInt(date[0]) * 3600 * 1000 +
                Integer.parseInt(date[1]) * 60 * 1000 +
                (int)(Double.parseDouble(date[2]) * 1000);
    }
}