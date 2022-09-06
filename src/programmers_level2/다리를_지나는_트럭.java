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
        Queue<Integer> truckOnBridge = new LinkedList<>();
        int bridgeWeight = 0;
        int count = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truckWeight = truck_weights[i];
            while(true) {
                if (truckOnBridge.isEmpty()) {
                    truckOnBridge.add(truckWeight);
                    bridgeWeight += truckWeight;
                    count++;
                    break;
                }
                else if(truckOnBridge.size() == bridge_length) {
                    Integer poll = truckOnBridge.poll();
                    bridgeWeight -= poll;
                }
                else {
                    if (bridgeWeight + truckWeight <= weight) {
                        truckOnBridge.add(truckWeight);
                        bridgeWeight += truckWeight;
                        count++;
                        break;
                    } else {
                        truckOnBridge.add(0);
                        count++;
                    }
                }
            }
        }

        return count + bridge_length;
    }
}
