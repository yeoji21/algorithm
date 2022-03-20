import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        fibo(N);
        IntStream.range(1, N+1).forEach(i -> System.out.print(arr[i] + " "));
    }

    private static int fibo(int n) {
        if(n == 1 || n == 2) return arr[n] = 1;
        if(arr[n] > 0) return arr[n];
        return arr[n] = fibo(n - 1) + fibo(n - 2);
    }
}