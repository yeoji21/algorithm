package rtg;

public class Main5 {
    Node root;
    public static void main(String[] args) throws Exception {
        Main5 tree = new Main5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);
    }

    public void DFS(Node root) {
        if(root == null) return;
        else{
            DFS(root.lt);
            System.out.print(root.data + " ");
            DFS(root.rt);
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