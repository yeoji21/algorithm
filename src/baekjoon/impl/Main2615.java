package baekjoon.impl;

import java.io.*;
import java.util.*;

public class Main2615 {
    /*
    내 풀이랑 다른데 굿
    https://m.blog.naver.com/kerochuu/221792539488
    */
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 19;
        Omok[][] map = new Omok[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = new Omok(getIntToken(tokenizer));
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j].value == 0) continue;
                if(checkX(map, i, j)) return;
                if(checkY(map, i, j)) return;
                if(checkCross(map, i, j)) return;
                if(checkRCross(map, i, j)) return;
            }
        }
        System.out.println("0");
    }

    boolean checkX(Omok[][] map, int i, int j){
        if(map[i][j].x) return false;
        int originX = i + 1, originY = j + 1;
        int target = map[i][j].value;
        int count = 1;
        while(true){
            i++;
            if(i >= map.length) break;
            if(map[i][j].value != target) break;
            count++;
            map[i][j].x = true;
        }
        if(count == 5){
            System.out.println(target);
            System.out.println(originX + " " + originY);
            return true;
        }
        return false;
    }

    boolean checkY(Omok[][] map, int i, int j){
        if(map[i][j].y) return false;
        int target = map[i][j].value;
        int originX = i + 1, originY = j + 1;
        int count = 1;
        while(true){
            j++;
            if(j >= map[0].length) break;
            if(map[i][j].value != target) break;
            count++;
            map[i][j].y = true;
        }
        if(count == 5){
            System.out.println(target);
            System.out.println(originX + " " + originY);
            return true;
        }
        return false;
    }

    boolean checkCross(Omok[][] map, int i, int j){
        if(map[i][j].cross) return false;
        int target = map[i][j].value;
        int originX = i + 1, originY = j + 1;
        int count = 1;
        while(true){
            i++;
            j++;
            if(i >= map.length || j >= map[0].length) break;
            if(map[i][j].value != target) break;
            count++;
            map[i][j].cross = true;
        }
        if(count == 5){
            System.out.println(target);
            System.out.println(originX + " " + originY);
            return true;
        }
        return false;
    }

    boolean checkRCross(Omok[][] map, int i, int j){
        if(map[i][j].rCross) return false;
        int target = map[i][j].value;
        int originX = i + 1, originY = j + 1;
        int count = 1;
        while(true){
            i++;
            j--;
            if(i >= map.length || j < 0) break;
            if(map[i][j].value != target) break;
            count++;
            map[i][j].rCross = true;
            originX = i + 1;
            originY = j + 1;
        }
        if(count == 5){
            System.out.println(target);
            System.out.println(originX + " " + originY);
            return true;
        }
        return false;
    }


    static class Omok{
        int value;
        boolean x, y, cross, rCross;

        public Omok(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main2615().solv();
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
