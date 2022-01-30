package inflean.stack_queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main7 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String essentialClasses = in.readLine();
        String allClasses = in.readLine();
        new Main7().solution(essentialClasses, allClasses);
    }

    public void solution(String essentialClasses, String allClasses) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : allClasses.toCharArray())
            queue.add(c);

        for (char essential : essentialClasses.toCharArray()) {
            if (queue.contains(essential)) {
                while (queue.remove() != essential);
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public void solution2(String essentialClasses, String allClasses) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : essentialClasses.toCharArray()) queue.offer(c);

        for (char c : allClasses.toCharArray()) {
            if (queue.contains(c)) {
                if(c != queue.poll()){
                    System.out.println("NO");
                    return;
                }
            }
        }
        if(!queue.isEmpty()){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}