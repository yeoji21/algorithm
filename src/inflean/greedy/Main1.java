package inflean.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> bodies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            bodies.add(new Body(h, w));
        }

        new Main1().solution(bodies);
    }

    private void solution(List<Body> bodies) {
        List<Body> sortByHeight = bodies.stream().sorted(Comparator.comparing(x -> -x.h)).collect(Collectors.toList());
        int result = 1;
        int maxWeight = sortByHeight.get(0).w;

        for (int i = 1; i < bodies.size(); i++) {
            if(sortByHeight.get(i).w > maxWeight){
                result ++;
                maxWeight = sortByHeight.get(i).w;
            }
        }
        System.out.println(result);
    }
    static class Body{
        int h, w;

        public Body(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}


