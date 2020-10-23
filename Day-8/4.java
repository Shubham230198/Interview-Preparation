class Main4 {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Pair {
        int nodeToNode = 0;
        int nodeToRoot = 0;

        Pair(int n1, int n2) {
            nodeToNode = n1;
            nodeToRoot = n2;
        }
    }

    public static Pair findMaxPathSum(Node node) {
        if(node == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        if(node.left == null && node.right == null) {
            return new Pair(node.data, node.data);
        }

        Pair lResult = findMaxPathSum(node.left);
        Pair rResult = findMaxPathSum(node.right);
        
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(10); 
        root.left = new Node(2); 
        root.right = new Node(10); 
        root.left.left = new Node(20); 
        root.left.right = new Node(1); 
        root.right.right = new Node(-25); 
        root.right.right.left = new Node(3); 
        root.right.right.right = new Node(4);

        Pair res = findMaxPathSum(root);
        System.out.println(res.nodeTonode);
    }         
}
