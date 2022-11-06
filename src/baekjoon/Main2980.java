package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2980 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int L = getIntToken(tokenizer);
        Map<Integer, TrafficLight> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            map.put(getIntToken(tokenizer), new TrafficLight(getIntToken(tokenizer), getIntToken(tokenizer)));
        }
        int time = 0;
        for (int i = 1; i < L; i++) {
            if(map.containsKey(i)){
                TrafficLight light = map.get(i);
                boolean isRed = time % (light.red + light.green) < light.red;
                if(isRed)
                    time += light.red - time % (light.red + light.green);
            }
            time++;
        }
        System.out.println(time);
    }

    static class TrafficLight{
        int red, green;

        public TrafficLight(int red, int green) {
            this.red = red;
            this.green = green;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2980().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
