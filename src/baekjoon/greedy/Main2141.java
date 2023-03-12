package baekjoon.greedy;

import java.io.*;
import java.util.*;

public class Main2141 {
    private StringBuilder answer = new StringBuilder();
    private void input(FastReader reader) throws Exception{
        int n = reader.nextIntLine();
        City[] cities = new City[n];
        long sum = 0;
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City(reader.nextInt(), reader.nextInt());
            sum += cities[i].people;
        }
        solution(cities, sum);
    }

    private void solution(City[] cities, long sum) {
        Arrays.sort(cities, Comparator.comparing((City c) -> c.location).thenComparing(c -> c.people));

        long people = 0;
        for (City city : cities) {
            people += city.people;
            if(people >= (sum + 1) / 2){
                System.out.println(city.location);
                return;
            }
        }

        System.out.println(answer);
    }

    long getDistance(City[] cities, int i, int j){
        return Math.abs(cities[i].location - cities[j].location)
                * (long) cities[i].people * (long) cities[j].people;
    }

    class City{
        int location;
        int people;

        public City(int location, int people) {
            this.location = location;
            this.people = people;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2141().input(new FastReader());
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextIntLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Integer.parseInt(str);
        }
    }
}
