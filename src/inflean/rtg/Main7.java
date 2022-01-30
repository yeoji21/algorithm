package inflean.rtg;

import java.util.LinkedList;
import java.util.Queue;

public class Main7 {
    Node root;
    public static void main(String[] args) throws Exception {
        Main7 tree = new Main7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.BFS(tree.root);
    }

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int[] checked = new int[8];
        int level = 0;

        while(!queue.isEmpty()){
            int len = queue.size();
            System.out.println("level = " + level++);

            for (int i = 0; i < len; i++) {
                Node removed = queue.remove();
                System.out.print(removed.data + " ");

                if (removed.lt != null && checked[removed.lt.data] == 0) {
                    queue.add(removed.lt);
                    checked[removed.lt.data] = 1;
                }
                if (removed.rt != null && checked[removed.rt.data] == 0) {
                    queue.add(removed.rt);
                    checked[removed.rt.data] = 1;
                }
            }

            System.out.println();
        }
    }

    static class Node{
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}
