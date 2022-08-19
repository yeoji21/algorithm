package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public static void main(String[] args) {
//        int solution = solution2(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        int solution = solution2(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
//        int solution = solution2(new int[]{1, 1}, new int[]{1, 5});

        System.out.println(solution);
    }

    public static int solution2(int[] queue1, int[] queue2) {
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        int sumA = 0;
        int sumB = 0;
        int result = 0;

        for (int i = 0; i < queue1.length; i++) {
            queueA.add(queue1[i]);
            sumA += queue1[i];
        }

        for (int i = 0; i < queue2.length; i++) {
            queueB.add(queue2[i]);
            sumB += queue2[i];
        }

        if((sumA + sumB) % 2 == 1) return -1;

        while (result < queue1.length * 4) {
            if(sumA == sumB) return result;
            else if (sumA > sumB) {
                Integer poll = queueA.poll();
                queueB.add(poll);
                sumA -= poll;
                sumB += poll;
            } else {
                Integer poll = queueB.poll();
                queueA.add(poll);
                sumB -= poll;
                sumA += poll;
            }
            result++;
        }

        return -1;
    }

    public static int solution(int[] queue1, int[] queue2) {
        int[] total = new int[queue1.length * 2];
        int sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            total[i] = queue1[i];
            sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            total[queue1.length + i] = queue2[i];
            sum += queue2[i];
        }
        if(sum % 2 == 1) return -1;
        int target = sum / 2;
        int startIdx = 0;
        int endIdx = queue1.length - 1;
        int answer = 0;

        int firstQueueSum = 0;
        for (int i = startIdx; i < endIdx + 1; i++) {
            firstQueueSum += total[i];
        }

        while (answer < total.length * 2) {
            if(firstQueueSum == target) {
                return answer;
            }
            else if (firstQueueSum > target) {
                firstQueueSum -= total[startIdx];
                startIdx++;
                if(startIdx == total.length) {
                    startIdx = 0;
                }
            } else {
                endIdx++;
                if(endIdx == total.length) {
                    endIdx = 0;
                }
                firstQueueSum += total[endIdx];
            }
            answer++;
        }

        return -1;
    }
}
