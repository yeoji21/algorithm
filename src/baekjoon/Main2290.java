package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2290 {
    private char[][] map;
    private int s;
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        s = Integer.parseInt(tokenizer.nextToken());
        String n = tokenizer.nextToken();
        map = new char[2 * s + 3][n.length() - 1 + ((2 + s) * n.length())];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], ' ');
        }

        int idx = 0;
        for (char ch : n.toCharArray()) {
            if(ch == '1')
                draw1(idx);
            else if(ch == '2')
                draw2(idx);
            else if(ch == '3')
                draw3(idx);
            else if(ch == '4')
                draw4(idx);
            else if(ch == '5')
                draw5(idx);
            else if(ch == '6')
                draw6(idx);
            else if(ch == '7')
                draw7(idx);
            else if(ch == '8')
                draw8(idx);
            else if(ch == '9')
                draw9(idx);
            else if(ch == '0')
                draw0(idx);
            idx += 2 + s + 1;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            answer.append(map[i]).append("\n");
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void draw0(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }

        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }
    private void draw9(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }

        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw8(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }

        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw7(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw6(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }

        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
        column = startColumn + 2 + s - 1;
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw5(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }
        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        column = startColumn + 2 + s - 1;
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw4(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        column = startColumn;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }

        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw3(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw2(int startColumn){
        int column = startColumn + 1;
        for (int i = 0; i < s; i++) {
            map[0][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length / 2][column + i] = '-';
        }
        for (int i = 0; i < s; i++) {
            map[map.length - 1][column + i] = '-';
        }
        column = startColumn + 2 + s - 1;
        for (int i = 1; i < s + 1; i++) {
            map[i][column] = '|';
        }
        column = startColumn;
        for (int i = map.length / 2 + 1; i < map.length / 2 + 1 + s; i++) {
            map[i][column] = '|';
        }
    }

    private void draw1(int startColumn){
        int column = startColumn + 2 + s - 1;
        int count = 0;
        for (int i = 1; i < map.length; i++) {
            if(count == s){
                count = 0;
                continue;
            }
            map[i][column] = '|';
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2290().solv();
    }
}
