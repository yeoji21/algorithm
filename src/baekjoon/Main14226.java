package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main14226 {
    private void solv() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int S = Integer.parseInt(br.readLine());

        int count = BFS(S);
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private int BFS(int target) {
        Queue<Emoji> queue = new LinkedList<>();
        Set<Emoji> set = new HashSet<>();
        Emoji em = new Emoji(1, null);
        queue.add(em);
        set.add(em);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Emoji emoji = queue.poll();
                if(emoji.display == target)
                    return count;

                if(emoji.clipBoard == null || emoji.display != emoji.clipBoard) {
                    Emoji e1 = new Emoji(emoji.display, emoji.display);
                    if(!set.contains(e1)) {
                        queue.add(e1);
                        set.add(e1);
                    }
                }
                if(emoji.clipBoard == null) continue;
                Emoji e2 = new Emoji(emoji.display + emoji.clipBoard, emoji.clipBoard);
                if(!set.contains(e2)) {
                    queue.add(e2);
                    set.add(e2);
                }

                if(emoji.display - 1 > 0) {
                    Emoji e3 = new Emoji(emoji.display - 1, emoji.clipBoard);
                    if(!set.contains(e3)) {
                        queue.add(e3);
                        set.add(e3);
                    }
                }
            }
            count++;
        }

        return -1;
    }

    static class Emoji{
        private int display;
        private Integer clipBoard;

        public Emoji(int display, Integer clipBoard) {
            this.display = display;
            this.clipBoard = clipBoard;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || o.getClass() != this.getClass()) return false;
            Emoji emoji = (Emoji) o;
            return this.display == emoji.display && Objects.equals(this.clipBoard, emoji.clipBoard);
        }

        @Override
        public int hashCode() {
            return Objects.hash(display, clipBoard);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main14226().solv();
    }
}
