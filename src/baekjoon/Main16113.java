package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main16113 {
    private Map<String, Integer> numberMap;
    char[][] words;
    boolean[] checked;

    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        initializeMap();
        int N = Integer.parseInt(br.readLine());
        words = new char[5][N / 5];
        checked = new boolean[N / 5];
        char[] array = br.readLine().toCharArray();

        int idx = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length; j++) {
                words[i][j] = array[idx++];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words[0].length; i++) {
            if(checked[i] || words[0][i] == '.') continue;
            int num = checkNumber(i);
            answer.append(num);
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int checkNumber(int column) {
        if(column + 1 >= words[0].length || (words[0][column + 1] == '.' && words[3][column] == '#')) {
            checked[column] = true;
            return 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 5; row++) {
            int count = 0;
            for (int i = column; i < column + 3; i++){
                checked[i] = true;
                if(words[row][i] == '#') count++;
            }
            if(row == 0 && count == 2) return 4;
            if(count == 1){
                if(words[row][column] == '#') sb.append("10");
                else sb.append("01");
            }
            else sb.append(count);
        }

        return numberMap.get(sb.toString());
    }

    private void initializeMap() {
        numberMap = new HashMap<>();
        numberMap.put("32223", 0);
        numberMap.put("11111", 1);
        numberMap.put("3013103", 2);
        numberMap.put("3013013", 3);
        numberMap.put("2230101", 4);
        numberMap.put("3103013", 5);
        numberMap.put("310323", 6);
        numberMap.put("301010101", 7);
        numberMap.put("32323", 8);
        numberMap.put("323013", 9);
    }

    public static void main(String[] args) throws Exception {
        new Main16113().solv();
    }
}
