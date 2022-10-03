package programmers_level2;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
    public static int solution2(int[] queue1, int[] queue2) {
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        long sumA = 0;
        long sumB = 0;
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
        long sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            total[i] = queue1[i];
            sum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            total[queue1.length + i] = queue2[i];
            sum += queue2[i];
        }
        if(sum % 2 == 1) return -1;
        long target = sum / 2;
        int startIdx = 0;
        int endIdx = queue1.length - 1;
        int answer = 0;

        long firstQueueSum = 0;
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

    public int solution3(int[] queue1, int[] queue2) {
        int[] total = new int[queue1.length + queue2.length];
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < queue1.length; i++) {
            total[i] = queue1[i];
            sumA += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            total[queue1.length + i] = queue2[i];
            sumB += queue2[i];
        }
        int indexA = 0;
        int indexB = queue1.length;
        int answer = 0;
        while (true){
            if (sumA > sumB) {
                int pop = total[indexA];
                sumA -= pop;
                sumB += pop;
                indexA = indexA + 1;
                if(indexA >= total.length) indexA = 0;
            } else if (sumA < sumB) {
                int pop = total[indexB];
                sumB -= pop;
                sumA += pop;
                indexB = indexB + 1;
                if(indexB >= total.length) indexB = 0;
            }else{
                return answer;
            }
            answer++;
            if(answer >= total.length * 2) return -1;
        }
    }
}
