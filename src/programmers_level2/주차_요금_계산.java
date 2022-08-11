package programmers_level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                        "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        Arrays.stream(solution)
                .forEach(System.out::println);
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inParking = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            if(split[2].equals("IN")){
                inParking.put(split[1], getMinutes(split[0]));
                if(!totalTime.containsKey(split[1]))
                    totalTime.put(split[1], 0);
            } else {
                totalTime.put(split[1], totalTime.get(split[1]) + getMinutes(split[0]) - inParking.get(split[1]));
                inParking.remove(split[1]);
            }
        }

        for (String key : inParking.keySet()) {
            Integer inTime = inParking.get(key);
            totalTime.put(key, totalTime.getOrDefault(key, 0) + (23 * 60 + 59 - inTime));
        }

        int[] result = new int[totalTime.size()];

        int i = 0;
        for (String key : totalTime.keySet()) {
            Integer time = totalTime.get(key);
            if(time <= fees[0]){
                result[i++] = fees[1];
                continue;
            }

            result[i++] = (int)(Math.ceil((time - fees[0]) / (fees[2] * 1.0))) * fees[3] + fees[1];
        }

        return result;
    }

    private static int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
