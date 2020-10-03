class Node {
    public int value;
    public Node right;
    public Node left;

    public Node(int val) {
        value = val;
        right = left = null;
    }
}

class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }
    public void addNode(int val) {
        root = addNodeRecursion(val, root);
    }
    Node addNodeRecursion(int val, Node cur) {
        if (cur == null) {
            cur = new Node(val);
            return cur;
        }
        if (cur.value <= val) {
            cur.right = addNodeRecursion(val, cur.right);
        }
        else {
            cur.left = addNodeRecursion(val, cur.left);
        }
        return cur;
    }

    public void inOrder() {
        System.out.println("\nPrint In-Order");
        inOrderRecursion(root);
    }
    void inOrderRecursion(Node cur) {
        if (cur == null)
            return;
        inOrderRecursion(cur.left);

        System.out.println(String.format("%d ", cur.value));

        inOrderRecursion(cur.right);
    }
    public void preOrder() {
        System.out.println("\nPrint Pre-Order");
        preOrderRecursion(root);
    }
    void preOrderRecursion(Node cur) {
        if (cur == null)
            return;
        
        System.out.println(String.format("%d ", cur.value));

        preOrderRecursion(cur.left);
        preOrderRecursion(cur.right);
    }
    public void postOrder() {
        System.out.println("\nPrint Post-Order");
        postOrderRecursion(root);
    }
    void postOrderRecursion(Node cur) {
        if (cur == null)
            return;
            
        postOrderRecursion(cur.left);
        postOrderRecursion(cur.right);
        
        System.out.println(String.format("%d ", cur.value));
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(9);
        tree.addNode(10);
        tree.addNode(3);
        tree.addNode(100);
        tree.addNode(5);
        tree.addNode(-100);

        // temos lg(n) folhas no máximo

        tree.inOrder();
        tree.preOrder();
        tree.postOrder();

        System.out.println("\nFim");
    }
}