package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
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
