/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {

        if(root==null) return null;
        getGST(root);
        return root;
    }

    public void getGST(TreeNode root)
    {
        if(root == null) return;
        getGST(root.right);
        sum=sum+root.val;
        root.val = sum;
        getGST(root.left);
        
        
    }
}