package inflean.array;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        List<Integer> memberA = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> memberB = Arrays.stream(in.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        new Main3().solution(memberA, memberB);
    }

    public void solution(List<Integer> memberA, List<Integer> memberB) {
        for (int i = 0; i < memberA.size(); i++) {
            if (memberA.get(i) - memberB.get(i) == -1)
                System.out.println("B");
            else if (memberA.get(i) - memberB.get(i) == -2)
                System.out.println("A");
            else if (memberA.get(i) ==  memberB.get(i))
                System.out.println("D");
            else if (memberA.get(i) - memberB.get(i) == 1)
                System.out.println("A");
            else if (memberA.get(i) - memberB.get(i) == 2)
                System.out.println("B");
        }
    }
}
