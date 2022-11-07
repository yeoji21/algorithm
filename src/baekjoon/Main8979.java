package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main8979 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = getIntToken(tokenizer);
        int K = getIntToken(tokenizer);
        List<Country> countries = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int country = getIntToken(tokenizer);
            int gold = getIntToken(tokenizer);
            int silver = getIntToken(tokenizer);
            int bronze = getIntToken(tokenizer);
            countries.add(new Country(country, gold, silver, bronze));
        }
        Collections.sort(countries);
        if(countries.get(0).country == K) {
            System.out.println("1");
            return;
        }

        int rank = 1;
        int gap = 1;
        for (int i = 1; i < countries.size(); i++) {
            Country country = countries.get(i);
            if(country.isEqualTo(countries.get(i - 1))) {
                gap++;
            }else{
                rank += gap;
                gap = 1;
            }
            if (country.country == K) break;
        }

        bw.write(rank + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Country implements Comparable<Country>{
        int country;
        int gold;
        int silver;
        int bronze;

        public Country(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean isEqualTo(Country o) {
            return this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main8979().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
