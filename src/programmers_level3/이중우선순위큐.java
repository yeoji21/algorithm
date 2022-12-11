package programmers_level3;

import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.util.Comparator.reverseOrder;

class 이중우선순위큐 {
    public int[] solution2(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer tokenizer;
        for (String op : operations) {
            tokenizer = new StringTokenizer(op);
            String command = tokenizer.nextToken();
            if (command.equals("D")) {
                if(map.size() == 0) continue;
                int type = Integer.parseInt(tokenizer.nextToken());
                Integer num;
                if (type == 1) {
                    num = map.lastKey();
                } else {
                    num = map.firstKey();
                }

                if (map.put(num, (map.get(num) - 1)) == 1) {
                    map.remove(num);
                }

            } else {
                int value = Integer.parseInt(tokenizer.nextToken());
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }


        int max = map.size() == 0 ? 0 : map.lastKey();
        int min = map.size() == 0 ? 0 : map.firstKey();
        return new int[]{max, min};
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String op : operations) {
            char command = op.charAt(0);
            if (command == 'D') {
                if (op.charAt(2) == '1') {
                    if(maxQ.isEmpty()) continue;
                    Integer poll = maxQ.poll();
                    minQ.remove(poll);
                } else{
                    if(minQ.isEmpty()) continue;
                    Integer poll = minQ.poll();
                    maxQ.remove(poll);
                }
            } else {
                op = op.replace("I ", "");
                int value = Integer.parseInt(op);
                maxQ.add(value);
                minQ.add(value);
            }
        }

        int max = maxQ.isEmpty() ? 0 : maxQ.poll();
        int min = minQ.isEmpty() ? 0 : minQ.poll();
        return new int[]{max, min};
    }
}
