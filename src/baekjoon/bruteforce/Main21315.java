package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main21315 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];
        for (int i = 1; i <= N; i++) {
            card[i - 1] = i;
        }
        int[] now = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; (1 << i) < N; i++) {
            for (int j = 1; (1 << j) < N; j++) {
                Deque<Integer> q = new ArrayDeque<>();
                for (int k = 0; k < N; k++) {
                    q.addLast(card[k]);
                }
                shuffle(q, i);
                shuffle(q, j);

                int idx = 0;
                while (!q.isEmpty()) {
                    if (q.pollFirst() != now[idx++]) {
                        break;
                    }
                }
                if (q.size() == 0) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }

    }

    private static void shuffle(Deque<Integer> q, int i) {
        int count = 0;
        for (int j = 1 << i; j < q.size(); j++) {
            q.add(q.poll());
            count++;
        }
        Deque<Integer> tempq = new ArrayDeque<>();
        for (int j = 0; j < count; j++) {
            tempq.add(q.pollLast());
        }

        count = q.size();
        for (int j = 0; j < 1 << i; j++) {
            for (int k = 0; k < count / 2; k++) {
                q.add(q.poll());
            }
            for (int k = 0; k < count / 2; k++) {
                tempq.add(q.pollLast());
            }
            count = count / 2;
        }
        while (!tempq.isEmpty()) {
            q.add(tempq.pollLast());
        }
    }
}
