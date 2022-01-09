package sort;

import java.io.*;
import java.util.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Integer[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        new Main6().solution(n, num);
    }

    public void solution(int n, Integer[] num) {
        Rank[] ranks = new Rank[n];

        for (int i = 0; i < n; i++) {
            Rank rank = new Rank(i + 1, num[i]);
            ranks[i] = rank;
        }

        Arrays.sort(ranks);

        for (int i = 0; i < n; i++) {
            if (ranks[i].getNumber() != i+1 && ranks[i].getHeight() != num[i]) System.out.print((i+1) + " ");
        }
    }

    private static class Rank implements Comparable<Rank>{
        private int number;
        private int height;

        public Rank(int number, int height) {
            this.number = number;
            this.height = height;
        }

        public int getNumber() {
            return number;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return "Rank{" +
                    "number=" + number +
                    ", height=" + height +
                    '}';
        }

        @Override
        public int compareTo(Rank o) {
            return this.getHeight() - o.getHeight() > 0 ? 1 : -1;
        }
    }
}

class Main6_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] num = Arrays.stream(in.readLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        new Main6_2().solution(n, num);
    }

    public void solution(int n, int[] num) {
        int[] temp = num.clone();
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            if(num[i] != temp[i]) System.out.print((i+1) + " ");
        }
    }
}