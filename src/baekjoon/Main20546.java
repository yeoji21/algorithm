package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20546 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = getIntLine(br);
        int[] stock = new int[14];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < stock.length; i++) {
            stock[i] = getIntToken(tokenizer);
        }
        int bnp = getBNP(money, stock);
        int timing = getTiming(money, stock);

        if(bnp > timing) System.out.println("BNP");
        else if(timing > bnp) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }

    private int getTiming(int money, int[] stock) {
        int week = 0;
        for (int i = 3; i < stock.length; i++) {
            if(stock[i - 1] > stock[i - 2] && stock[i - 2] > stock[i - 3]){
                money += stock[i] * week;
                week = 0;
            }
            if (stock[i - 1] < stock[i - 2] && stock[i - 2] < stock[i - 3]) {
                week += money / stock[i];
                money = money % stock[i];
            }
        }
        return money + week * stock[stock.length - 1];
    }

    private int getBNP(int money, int[] stock) {
        int week = 0;
        for (int s : stock) {
            if(s > money) continue;
            week += money / s;
            money = money % s;
        }
        return money + stock[stock.length - 1] * week;
    }

    public static void main(String[] args) throws Exception {
        new Main20546().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
