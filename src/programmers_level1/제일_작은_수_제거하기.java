package programmers_level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        else{
            int min = Arrays.stream(arr).min().getAsInt();
            int[] result = new int[arr.length - 1];

            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == min) continue;
                result[idx++] = arr[i];
            }
            return result;
        }
    }
}
