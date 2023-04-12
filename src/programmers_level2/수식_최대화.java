package programmers_level2;

import java.util.*;

public class 수식_최대화 {
    private char[] ops = {'+', '-', '*'};
    private long answer = 0;

    public long solution(String s) {
        List<Long> nums = new ArrayList<>();
        Map<Character, List<Integer>> op = new HashMap<>();
        for(char ch : ops){
            op.put(ch, new ArrayList<>());
        }
        long num = 0;
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else{
                op.get(ch).add(idx++);
                nums.add(num);
                num = 0;
            }
        }
        nums.add(num);
        DFS(nums, op, 0, new char[3]);
        return answer;
    }

    void DFS(List<Long> nums, Map<Character, List<Integer>> op, int level, char[] selected){
        if(level == 3){
            List<Long> copyNum = new ArrayList<>(nums);
            Map<Character, List<Integer>> copyOp = new HashMap<>();
            for(Map.Entry<Character, List<Integer>> e : op.entrySet()){
                copyOp.put(e.getKey(), new ArrayList<>(e.getValue()));
            }

            long num =  calculate(copyNum, copyOp, selected);
            answer = Math.max(answer, Math.abs(num));
            return;
        }

        for(int i = 0; i < 3; i++){
            if(ops[i] == 'X') continue;
            char temp = ops[i];

            selected[level] = temp;
            ops[i] = 'X';
            DFS(nums, op, level + 1, selected);
            ops[i] = temp;
        }
    }

    long calculate(List<Long> nums, Map<Character, List<Integer>> op, char[] selected){
        for(char ch : selected){
            List<Integer> idxs = op.get(ch);
            if(idxs.size() == 0) continue;
            for(int idx : idxs){
                if(ch == '+'){
                    nums.add(idx, nums.remove(idx) + nums.remove(idx));
                }else if(ch == '-'){
                    nums.add(idx, nums.remove(idx) - nums.remove(idx));
                }else{
                    nums.add(idx, nums.remove(idx) * nums.remove(idx));
                }

                for(Map.Entry<Character, List<Integer>> e : op.entrySet()){
                    List<Integer> list = op.get(e.getKey());
                    for(int i = 0; i < list.size(); i++){
                        if(list.get(i) > idx)
                            list.set(i, list.get(i) - 1);
                    }
                }
            }
        }
        return nums.get(0);
    }
}
