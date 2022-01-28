import java.util.*;

public class Main {
    static Block[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Block[] blocks = new Block[n];
        dp = new Block[n];
        for (int i = 0; i < n; i++) dp[i] = new Block(0, 0, 0);

        for (int i = 0; i < n; i++) {
            blocks[i] = new Block(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        new Main().solution(blocks);
    }

    public void solution(Block[] blocks) {
        Block[] sortedBlocks = Arrays.stream(blocks).sorted(Comparator.comparing(b -> b.width)).toArray(Block[]::new);
        dp[0] = sortedBlocks[0];
        int len = 0;
        for (int i = 1; i < sortedBlocks.length; i++) {
            if (sortedBlocks[i].weight > dp[len].weight) {
                dp[++len] = sortedBlocks[i];
            }
            else{
//                int idx = binarySearch(0, len, sortedBlocks[i].weight);
//                dp[idx] = sortedBlocks[i];
                if (sortedBlocks[i].height > dp[len].height)
                    dp[len] = sortedBlocks[i];
            }
        }

        Arrays.stream(dp).forEach(System.out::print);
        System.out.println();
        System.out.println(Arrays.stream(dp).mapToInt(d -> d.height).sum());
    }

    private int binarySearch(int left, int right, int key) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid].weight < key) {
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return right;
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