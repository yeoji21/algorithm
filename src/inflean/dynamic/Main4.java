package inflean.dynamic;

import java.util.*;

public class Main4 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Block[] blocks = new Block[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            blocks[i] = new Block(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        new Main4().solution(blocks);
    }

    public void solution(Block[] blocks) {
        Block[] sortedBlocks = Arrays.stream(blocks).sorted(Comparator.comparing(b -> -b.width)).toArray(Block[]::new);
        dp[0] = sortedBlocks[0].height;

        for (int i = 1; i < sortedBlocks.length; i++) {
            dp[i] = sortedBlocks[i].height;
            for (int j = i-1; j >= 0; j--) {
                if(sortedBlocks[i].weight < sortedBlocks[j].weight)
                    dp[i] = Math.max(dp[j] + sortedBlocks[i].height, dp[i]);
            }
        }
        Arrays.stream(dp).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }


    static class Block {
        int width, height, weight;

        public Block(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "width=" + width +
                    '}';
        }
    }
}