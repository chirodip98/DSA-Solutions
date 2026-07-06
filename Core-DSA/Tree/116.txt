package Core-DSA.Tree;

public class 116 {

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null) return null;
        Queue<Node> treeQ = new LinkedList<>();
        treeQ.offer(root);

        while(!treeQ.isEmpty())
        {
            int size = treeQ.size();
            Node prev = null;

            for(int i=0; i<size; i++)
            {
                Node node = treeQ.poll();
                if(prev!=null) prev.next = node;
                prev = node;
                if(node.left!=null) treeQ.offer(node.left);
                if(node.right!=null) treeQ.offer(node.right);
            }

            prev.next = null;

        }

        return root;

    }
}

class Solution {
    public Node connect(Node root) {

        if (root == null)
            return null;
        Node start = root;

        while (start.left != null) {
            Node current = start;
            while (current != null) {

                current.left.next = current.right;
                if (current.next != null)
                    current.right.next = current.next.left;
                current = current.next;
            }
            start = start.left;
        }
        return root;

    }
}

    
}
