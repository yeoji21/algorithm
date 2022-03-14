package baekjoon.stack_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MyDeque deque = new MyDeque();

        while (--N >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if(operator.equals("push_front")) deque.pushFront(Integer.parseInt(st.nextToken()));
            else if(operator.equals("push_back")) deque.pushBack(Integer.parseInt(st.nextToken()));
            else if(operator.equals("pop_front")) deque.popFront();
            else if(operator.equals("pop_back")) deque.popBack();
            else if(operator.equals("size")) deque.size();
            else if(operator.equals("empty")) deque.empty();
            else if(operator.equals("front")) deque.front();
            else if(operator.equals("back")) deque.back();
        }
        deque.print();
    }

    private static class MyDeque {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        public void pushFront(int v){
            deque.addFirst(v);
        }

        public void pushBack(int v){
            deque.addLast(v);
        }

        public void popFront(){
            if(deque.isEmpty()) result.add(-1);
            else {
                int t = deque.removeFirst();
                result.add(t);
            }
        }

        public void popBack(){
            if(deque.isEmpty()) result.add(-1);
            else {
                int t = deque.removeLast();
                result.add(t);
            }
        }

        public void size(){
            result.add(deque.size());
        }

        public void empty(){
            result.add(deque.isEmpty() ? 1 : 0);
        }

        public void front(){
            if(deque.isEmpty()) result.add(-1);
            else result.add(deque.peekFirst());
        }

        public void back(){
            if(deque.isEmpty()) result.add(-1);
            else result.add(deque.peekLast());
        }

        public void print(){
            result.forEach(System.out::println);
        }
    }
}
