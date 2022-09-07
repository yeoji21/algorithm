package programmers_level2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
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

    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

}
