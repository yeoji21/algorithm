package programmers_level2;

import java.util.Arrays;

public class h_index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations[citations.length / 2] + 1; i++) {
            int idx = binarySearch(citations, i);
            if (i <= citations.length - idx) {
                answer = i;
            }
        }

        return answer;
    }

    private int binarySearch(int[] citations, int target) {
        int left = 0;
        int right = citations.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(citations[mid] == target) return mid;
            else if(citations[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    public int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}
