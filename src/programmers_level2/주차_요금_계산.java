package programmers_level2;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class 주차_요금_계산 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                        "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        Arrays.stream(solution)
                .forEach(System.out::println);
    }

    //https://velog.io/@ujone/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A3%BC%EC%B0%A8-%EC%9A%94%EA%B8%88-%EA%B3%84%EC%82%B0-JAVA

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Car> recordMap = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String status = split[2];
            Car item = new Car(split[0], split[1]);

            if (status.equals("IN")) {
                recordMap.put(item.number, item);
            } else if (status.equals("OUT")) {
                Car car = recordMap.get(item.number);
                long time = Math.abs(Duration.between(item.time, car.time).toMinutes());
                times.put(car.number, times.getOrDefault(car.number, 0) + (int) time);
                recordMap.remove(car.number);
            }
        }

        for (String key : recordMap.keySet()) {
            Car car = recordMap.get(key);
            long time = Math.abs(Duration.between(LocalTime.of(23, 59), car.time).toMinutes());
            times.put(key, times.getOrDefault(key, 0) + (int) time);
            recordMap.remove(key);
        }

        List<String> keyList = times.keySet()
                .stream()
                .sorted(Comparator.comparing(k -> k))
                .collect(Collectors.toList());

        int basicTime = fees[0];
        int basicFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];

        for (int i = 0; i < keyList.size(); i++) {
            Integer totalTime = times.get(keyList.get(i));

            if(totalTime <= basicTime){
                result.add(basicFee);
                continue;
            }
            int totalFee = basicFee;
            totalTime -= basicTime;
            totalFee += Math.ceil(totalTime / (addTime * 1.0)) * addFee;
            result.add(totalFee);
        }

        return result.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    static class Car{
        LocalTime time;
        String number;

        public Car(String time, String number) {
            String[] split = time.split(":");
            this.time = LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(time, car.time) && Objects.equals(number, car.number);
        }

        @Override
        public int hashCode() {
            return Objects.hash(time, number);
        }
    }
}
