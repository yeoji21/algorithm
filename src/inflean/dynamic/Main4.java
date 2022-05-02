package inflean.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {
    private static List<Block> blockList;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        blockList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            blockList.add(new Block(getIntToken(st), getIntToken(st), getIntToken(st)));
        }

        blockList.sort(Comparator.comparing(Block::getWidth).reversed());
        buildTower();
    }

    private static void buildTower() {
        blockList.get(0).setMaxTopHeight(blockList.get(0).height);

        for (int i = 1; i < blockList.size(); i++) {
            Block top = blockList.get(i);
            top.setMaxTopHeight(top.height);
            for (int j = i - 1; j >= 0; j--) {
                Block bottom = blockList.get(j);
                if (top.weight < bottom.weight) {
                    top.setMaxTopHeight(Math.max(bottom.getMaxTopHeight() + top.height, top.getMaxTopHeight()));
                }
            }
        }
        System.out.println(blockList.stream().max(Comparator.comparing(Block::getMaxTopHeight)).get().maxTopHeight);
    }

    private static int getIntToken(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static class Block{
        int width, height, weight;
        int maxTopHeight;

        public Block(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        public int getWidth() {
            return width;
        }

        public int getMaxTopHeight() {
            return maxTopHeight;
        }

        public void setMaxTopHeight(int maxTopHeight) {
            this.maxTopHeight = maxTopHeight;
        }
    }
}