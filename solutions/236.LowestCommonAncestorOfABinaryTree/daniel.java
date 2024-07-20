/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode helper(TreeNode root, int val1, int val2){

        if(root == null){
            return null;
        }

        if(root.val == val1 || root.val == val2){
            return root;
        }

        TreeNode leftNode = helper(root.left,val1,val2);
        TreeNode rightNode = helper(root.right, val1, val2);

        if(leftNode != null && rightNode != null){
            return root;
        }else{

            return leftNode != null ? leftNode : rightNode;
        }

        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return helper(root,p.val,q.val);

    }
}