

//Remove nodes on root-to-leaf paths, of length < k. In Binary Tree.
class Main3{
    static class Node  { 
        int data; 
        Node left, right; 
    
        public Node(int item)  
        { 
            data = item; 
            left = right = null; 
        } 
    }

    //*********************************************Main Function********************** */

    public static Node removeExtra(Node node, int level, int k) {
        if(node == null) {     //some inter-mediatery node, with only one child can sent me here
            return null;
        }

        if(node.left == null && node.right == null) {       //if we are at leaf node
            if(level < k) {
                return null;
            }
            else {
                return node;
            }
        }

        node.left = removeExtra(node.left, level + 1, k);
        node.right = removeExtra(node.right, level + 1, k);

        if(node.left == null && node.right == null) {
            return null;
        }
        else {
            return node;
        }
    }


    /********************************************************************************************** */

    static void printInorder(Node node)  
    { 
        if (node != null)  
        { 
            printInorder(node.left); 
            System.out.print(node.data + " "); 
            printInorder(node.right); 
        } 
    } 

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.left.left.left = new Node(7); 
        root.right.right = new Node(6); 
        root.right.right.left = new Node(8);

        int k = 4;
        removeExtra(root, 1, k);

        printInorder(root);

    }
}
