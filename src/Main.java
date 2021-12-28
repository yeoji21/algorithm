import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        T.solution(n, m, a, b);
    }

    private void solution(int n, int m, int[] a, int[] b) {
        int x = 0, y = 0;
        int[] result = new int[n + m];

        int idx = 0;
        for (; x < n && y < m; idx++) {
            if(a[x] < b[y])
                result[idx] = a[x++];
            else
                result[idx] = b[y++];
        }

        while(x < n) result[idx++] = a[x++];

        while(y < m) result[idx++] = b[y++];

        Arrays.stream(result).forEach(System.out::print);
    }
}