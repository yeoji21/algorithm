package array;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<String> strNumList = Arrays.stream(in.readLine().split(" ")).collect(Collectors.toList());

        new Main6().solution(strNumList);
    }

    private void solution(List<String> strNumList) {
        List<Integer> numList = strListToNumList(strNumList);
        int[] prime = getPrimeNumbers();

        for (Integer num : numList) {
            if (prime[num] == 0 && num != 0 && num != 1)
                System.out.print(num + " ");
        }
    }

    private List<Integer> strListToNumList(List<String> strNumList) {
        List<Integer> numList = new ArrayList<>();

        for (String strNum : strNumList) {
            numList.add(Integer.parseInt(new StringBuilder(strNum).reverse().toString()));
        }
        return numList;
    }

    private int[] getPrimeNumbers() {
        int[] prime = new int[100_001];

        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 0){
                for (int j = 2; i*j< prime.length; j++)
                    prime[i*j] = 1;
            }
        }
        return prime;
    }

}