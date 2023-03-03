import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void main(String[] args) throws Exception {
        new Main().solv();
    }

    private int getIntLine(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int getIntToken(StringTokenizer tokenizer) {
        return Integer.parseInt(tokenizer.nextToken());
    }
}