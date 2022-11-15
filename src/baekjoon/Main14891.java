package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main14891 {
    private char[][] gear;
    private boolean[] checked;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        gear = new char[4][8];
        for (int i = 0; i < 4; i++) {
            gear[i] = br.readLine().toCharArray();
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int gearNumber = getIntToken(tokenizer) - 1;
            int d = getIntToken(tokenizer);
            checked = new boolean[4];
            checked[gearNumber] = true;
            if (d == 1) {
                rotateClockwise(gearNumber);
            }else{
                rotateCounterClockwise(gearNumber);
            }
        }
        int answer = 0;
        if(gear[0][0] == '1') answer += 1;
        if(gear[1][0] == '1') answer += 2;
        if(gear[2][0] == '1') answer += 4;
        if(gear[3][0] == '1') answer += 8;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void rotateClockwise(int gearNumber) {
        if(gearNumber + 1 < 4 && !checked[gearNumber + 1])
            rotateRightGear(gearNumber, 1);
        if(gearNumber -1 >= 0 && !checked[gearNumber - 1])
            rotateLeftGear(gearNumber, 1);

        char temp = gear[gearNumber][0];
        gear[gearNumber][0] = gear[gearNumber][7];
        gear[gearNumber][7] = gear[gearNumber][6];
        gear[gearNumber][6] = gear[gearNumber][5];
        gear[gearNumber][5] = gear[gearNumber][4];
        gear[gearNumber][4] = gear[gearNumber][3];
        gear[gearNumber][3] = gear[gearNumber][2];
        gear[gearNumber][2] = gear[gearNumber][1];
        gear[gearNumber][1] = temp;
    }

    private void rotateCounterClockwise(int gearNumber) {
        if(gearNumber + 1 < 4 && !checked[gearNumber + 1])
            rotateRightGear(gearNumber, -1);
        if(gearNumber -1 >= 0 && !checked[gearNumber - 1])
            rotateLeftGear(gearNumber, -1);

        char temp = gear[gearNumber][0];
        gear[gearNumber][0] = gear[gearNumber][1];
        gear[gearNumber][1] = gear[gearNumber][2];
        gear[gearNumber][2] = gear[gearNumber][3];
        gear[gearNumber][3] = gear[gearNumber][4];
        gear[gearNumber][4] = gear[gearNumber][5];
        gear[gearNumber][5] = gear[gearNumber][6];
        gear[gearNumber][6] = gear[gearNumber][7];
        gear[gearNumber][7] = temp;
    }

    private void rotateLeftGear(int centerGear, int d) {
        int gearNumber = centerGear - 1;
        if (gearNumber >= 0 && gear[centerGear][6] != gear[gearNumber][2] && !checked[gearNumber]) {
            checked[gearNumber] = true;
            if(d == 1) rotateCounterClockwise(gearNumber);
            else rotateClockwise(gearNumber);
        }
    }

    private void rotateRightGear(int centerGear, int d) {
        int gearNumber = centerGear + 1;
        if (gearNumber < 4 && gear[centerGear][2] != gear[gearNumber][6] && !checked[gearNumber]) {
            checked[gearNumber] = true;
            if(d == 1) rotateCounterClockwise(gearNumber);
            else rotateClockwise(gearNumber);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14891().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
