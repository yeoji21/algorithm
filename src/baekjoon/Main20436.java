package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main20436 {
    /*
    자음은 왼손, 모음은 오른손으로 입력
    두손을 동시에 움직일 수 없음
     */
    private Map<Character, int[]> left, right;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        char initialLeft = tokenizer.nextToken().charAt(0);
        char initialRight = tokenizer.nextToken().charAt(0);
        String target = br.readLine();
        solution(target, initialLeft, initialRight);
    }

    private void solution(String target, char nowLeft, char nowRight) {
        initializeLeft();
        initailizeRight();
        int answer = 0;
        for (char ch : target.toCharArray()) {
            int distance = getDistance(ch, nowLeft, nowRight);
            if(left.containsKey(ch)) nowLeft = ch;
            else nowRight = ch;
            answer += distance + 1;
        }
        System.out.println(answer);
    }

    int getDistance(char ch, char nowLeft, char nowRight) {
        if (left.containsKey(ch)) {
            int[] to = left.get(ch);
            int[] from = left.get(nowLeft);
            return Math.abs(to[0] - from[0]) + Math.abs(to[1] - from[1]);
        }else{
            int[] to = right.get(ch);
            int[] from = right.get(nowRight);
            return Math.abs(to[0] - from[0]) + Math.abs(to[1] - from[1]);
        }
    }

    private void initailizeRight() {
        right = new HashMap<>();
        right.put('y', new int[]{0, 5});
        right.put('u', new int[]{0, 6});
        right.put('i', new int[]{0, 7});
        right.put('o', new int[]{0, 8});
        right.put('p', new int[]{0, 9});
        right.put('h', new int[]{1, 5});
        right.put('j', new int[]{1, 6});
        right.put('k', new int[]{1, 7});
        right.put('l', new int[]{1, 8});
        right.put('b', new int[]{2, 4});
        right.put('n', new int[]{2, 5});
        right.put('m', new int[]{2, 6});
    }

    private void initializeLeft() {
        left = new HashMap<>();
        left.put('q', new int[]{0, 0});
        left.put('w', new int[]{0, 1});
        left.put('e', new int[]{0, 2});
        left.put('r', new int[]{0, 3});
        left.put('t', new int[]{0, 4});
        left.put('a', new int[]{1, 0});
        left.put('s', new int[]{1, 1});
        left.put('d', new int[]{1, 2});
        left.put('f', new int[]{1, 3});
        left.put('g', new int[]{1, 4});
        left.put('z', new int[]{2, 0});
        left.put('x', new int[]{2, 1});
        left.put('c', new int[]{2, 2});
        left.put('v', new int[]{2, 3});
    }

    public static void main(String[] args) throws Exception {
        new Main20436().solv();
    }
}
