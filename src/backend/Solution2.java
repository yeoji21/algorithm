package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
//        int[] solution = solution(new int[]{20, 23, 24},
//                new int[][]{{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000,
//                }, {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000,},
//                        {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}},
//                new int[]{100000, 100000, 100000});

        int[] solution = solution(new int[]{24, 59, 59, 60},
                new int[][]{{50000, 50000,50000,50000,50000,50000,50000,50000,50000,50000,50000,50000},
                        {50000, 50000,50000,50000,50000,50000,50000,50000,50000,50000,50000,50000},
                        {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
                        {50000, 50000,50000,50000,50000,50000,50000,50000,50000,50000,50000,50000}},
                new int[]{350000, 50000, 40000, 50000});

        Arrays.stream(solution).forEach(System.out::println);
    }

    private static int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] result = new int[2];

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < periods.length; i++) {
            customers.add(new Customer(periods[i], payments[i], estimates[i]));
        }

        for (Customer customer : customers) {
            boolean thisMonth = customer.thisMonthVIPcheck();
            boolean nextMonth = customer.nextMonthVIPcheck();

            if(!thisMonth && nextMonth) result[0]++;
            if(thisMonth && !nextMonth) result[1]++;
        }

        return result;
    }

    static class Customer {
        int period;
        int[] payments;
        int estimate;

        public Customer(int period, int[] payments, int estimate) {
            this.period = period;
            this.payments = payments;
            this.estimate = estimate;
        }

        int getThisMonthRecentSum() {
            return Arrays.stream(payments).sum();
        }

        int getNextMonthRecentSum() {
            return getThisMonthRecentSum() - payments[0] + estimate;
        }

        boolean thisMonthVIPcheck() {
            if (period < 24) return false;
            if (period < 60 && getThisMonthRecentSum() >= 900000) return true;
            if (period >= 60 && getThisMonthRecentSum() >= 600000) return true;
            else return false;
        }

        boolean nextMonthVIPcheck() {
            if(period + 1 < 24) return false;
            if (period + 1 < 60 && getNextMonthRecentSum() >= 900000) return true;
            if (period + 1 >= 60 && getNextMonthRecentSum() >= 600000) return true;
            else return false;
        }
    }
}
