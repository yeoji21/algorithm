package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTrucks = new LinkedList<>();
        Queue<Truck> movingTructks = new LinkedList<>();
        for (int truck : truck_weights) {
            waitingTrucks.add(truck);
        }
        int answer = 0;
        int weightOnBridge = 0;

        do {
            answer++;
            while (!movingTructks.isEmpty() && answer - movingTructks.peek().arrivedTime >= bridge_length) {
                Truck truck = movingTructks.poll();
                weightOnBridge -= truck.weight;
            }

            if (!waitingTrucks.isEmpty() && weightOnBridge + waitingTrucks.peek() <= weight) {
                Integer poll = waitingTrucks.poll();
                movingTructks.add(new Truck(poll, answer));
                weightOnBridge += poll;
            }

        } while (!waitingTrucks.isEmpty() || !movingTructks.isEmpty());

        return answer;
    }

    static class Truck{
        int weight;
        int arrivedTime;

        public Truck(int weight, int arrivedTime) {
            this.weight = weight;
            this.arrivedTime = arrivedTime;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if(q.size() == bridge_length) {
                    bridgeWeight -= q.poll();
                }
                if (q.size() < bridge_length && bridgeWeight + truck <= weight) {
                    q.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                } else {
                    q.add(0);
                    time++;
                }
            }
        }
        return time + bridge_length;
    }
}
