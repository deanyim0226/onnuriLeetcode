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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode currNode = root;
        TreeNode ans = null;

        while(root != null){

            int currVal = root.val;

            if(p.val < currVal && q.val < currVal){
                root = root.left;
            }else if(p.val > currVal && q.val > currVal){
                root = root.right;
            }else{
                ans = root;
                break;
            }
        }

        return ans;
    }
}