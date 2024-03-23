/**
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

    public boolean isSame(TreeNode parent, TreeNode sub){
        if(parent == null && sub == null){
            return true;
        }

        if(parent == null || sub == null){
            return false;
        }

        if(parent.val != sub.val){
            return false;
        }

        return isSame(parent.left,sub.left) && isSame(parent.right, sub.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        Boolean ans = false;
        while(!queue.isEmpty()){
            
            int size = queue.size();

            for(int i =0; i< size; i++){
                TreeNode currNode = queue.poll();
                TreeNode sub = subRoot;
                ans = isSame(currNode,sub);

                if(ans){
                    return true;
                }
                if(currNode.left != null){
                    
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    queue.add(currNode.right);
                }
            }
        }


        return ans;
    }
}