package programmers_level2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class 주차_요금_계산2 {
    // TODO: 2022/09/07 해쉬맵 쓰고 정렬하는 것보다 트리맵 쓰는게 훨씬 빠름
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basePrice = fees[1];
        int addTime = fees[2];
        int addPrice = fees[3];

        Map<String, LocalTime> inParking = new HashMap<>();
//        Map<String, Integer> totalParkingTime = new HashMap<>();
        Map<String, Integer> totalParkingTime = new TreeMap<>();

        for (String record : records) {
            String[] commands = record.split(" ");
            LocalTime localTime = getLocalTime(commands);
            String carNumber = commands[1];

            if (commands[2].equals("IN")) {
                inParking.put(carNumber, localTime);
            } else {
                int parkingTime = getParkingTime(inParking, localTime, carNumber);
                totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + parkingTime);
                inParking.remove(carNumber);
            }
        }

        for (String carNumber : inParking.keySet()) {
            int parkingTime = getParkingTime(inParking, LocalTime.of(23, 59), carNumber);
            totalParkingTime.put(carNumber, totalParkingTime.getOrDefault(carNumber, 0) + parkingTime);
        }

//        List<String> sortedCarNumbers = totalParkingTime.keySet()
//                .stream()
//                .sorted()
//                .collect(Collectors.toList());

        int[] answer = new int[totalParkingTime.size()];
        int idx = 0;

        for (String carNumber : totalParkingTime.keySet()) {
            int totalPrice = basePrice;
            Integer parkingTime = totalParkingTime.get(carNumber);
            parkingTime -= basicTime;
            while (parkingTime > 0) {
                parkingTime -= addTime;
                totalPrice += addPrice;
            }
            answer[idx++] = totalPrice;
        }

        return answer;
    }

    private int getParkingTime(Map<String, LocalTime> inParking, LocalTime localTime, String carNumber) {
        return (int) Duration.between(inParking.get(carNumber), localTime).toMinutes();
    }

    private LocalTime getLocalTime(String[] commands) {
        String[] times = commands[0].split(":");
        return LocalTime.of(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
    }
}
