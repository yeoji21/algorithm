package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {
    /*
    1부터 연속적인 번호를 가진 스위치들
    스위치는 on(1) || off(0)
    학생들은 번호를 하나씩 부여 받음
    남 : 자기 번호의 배수에 해당하는 스위치 toggle
    여 : 자기 스위치를 중심으로 상태가 같은 대칭만큼 상태 변경

    출력 : 각각 빈칸을 사이에 두고 한 줄에 20개의 스위치씩
     */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = getIntLine(br);
        int[] sw = new int[n + 1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            sw[i] = getIntToken(tokenizer);
        }
        int m = getIntLine(br);
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int gender = getIntToken(tokenizer);
            int num = getIntToken(tokenizer);
            toggle(gender, num, sw);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            answer.append(sw[i]).append(" ");
            if(i % 20 == 0) answer.append("\n");
        }
        System.out.println(answer);
    }

    private void toggle(int gender, int num, int[] sw) {
        if(gender == 1){
            toggleForBoys(num, sw);
        }else{
            toggleForGirls(num, sw);
        }
    }

    private void toggleForGirls(int num, int[] sw) {
        toggle(sw, num);
        int len = Math.min(num - 1, sw.length - num - 1);
        for (int i = 1; i <= len; i++) {
            if(sw[num - i] != sw[num + i]) break;
            toggle(sw, num - i);
            toggle(sw, num + i);
        }
    }

    private void toggleForBoys(int num, int[] sw) {
        for (int i = num; i < sw.length; i++) {
            if(i % num == 0)
                toggle(sw, i);
        }
    }

    private void toggle(int[] sw, int idx) {
        sw[idx] = sw[idx] == 1 ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        new Main1244().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
