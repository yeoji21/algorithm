package programmers_level2;

import java.util.Arrays;

public class h_index {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = Integer.MIN_VALUE;

        int max = Arrays.stream(citations)
                .max()
                .getAsInt();

        for (int citationCount = 0; citationCount <= max; citationCount++) {
            int idx = binarySearch(citations, citationCount);
            if(citations.length - idx >= citationCount)
                hIndex = Integer.max(hIndex, citationCount);
        }

        return hIndex;
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

    int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(array[mid] == target) return mid;
            if(array[mid] < target) start = mid + 1;
            else if(array[mid] > target) end = mid - 1;
        }

        return start;
    }
}
