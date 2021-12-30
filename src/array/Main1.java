package array;

import java.util.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        int count = Integer.parseInt(in.readLine());
//        String strNumbers = in.readLine();
//        List<Integer> numbers = Arrays.stream(strNumbers.split(" "))
//                .map(Integer::parseInt).collect(Collectors.toList());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        new Main1().solution(numbers);
    }

    public void solution(List<Integer> numbers) {
        System.out.print(numbers.get(0)+" ");
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i-1))
                System.out.print(numbers.get(i)+" ");
        }
    }
}