package backend;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
    public static void main(String[] args) {
//        int[] solution = solution(5, new String[]{"100 1 3", "500 4", "2000 5"}, new String[]{
//                "300 3 5", "1500 1", "100 1 3", "50 1 2"});

        int[] solution = solution(4, new String[]{"38 2 3", "394 1 4"}, new String[]{
                "10 2 3", "300 1 2 3 4", "500 1"});

        Arrays.stream(solution).forEach(System.out::println);
    }


    private static int[] solution(int n, String[] plans, String[] clients) {
        int[] result = new int[clients.length];

        int[] additionalServices = new int[n + 1];
        int[] prices = new int[plans.length + 1];
        setPlans(plans, additionalServices, prices);

        for (int i = 0; i < clients.length; i++) {
            StringTokenizer st = new StringTokenizer(clients[i]);
            int minimumPrice = Integer.parseInt(st.nextToken());
            int minimumPlan = getMinimumPlan(additionalServices, st);

            if(minimumPlan > 0){
                for (int plan = minimumPlan; plan < prices.length; plan++) {
                    if(minimumPrice <= prices[plan]) {
                        result[i] = plan;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private static int getMinimumPlan(int[] additionalServices, StringTokenizer st) {
        int minimumPlan = 0;
        while (st.hasMoreTokens()) {
            int service = Integer.parseInt(st.nextToken());
            int findPlan = additionalServices[service];
            if(findPlan == 0) {
                minimumPlan = 0;
                break;
            }
            minimumPlan = Math.max(findPlan, minimumPlan);
        }
        return minimumPlan;
    }

    private static void setPlans(String[] plans, int[] additionalServices, int[] prices) {
        for (int i = 0; i < plans.length; i++) {
            StringTokenizer st = new StringTokenizer(plans[i]);
            prices[i + 1] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int token = Integer.parseInt(st.nextToken());
                additionalServices[token] = i + 1;
            }
        }
    }
}
