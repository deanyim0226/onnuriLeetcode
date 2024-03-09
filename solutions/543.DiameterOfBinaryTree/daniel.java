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

    private int diameter = 0;

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        this.diameter = Math.max(leftHeight+rightHeight, this.diameter);
        return Math.max(leftHeight,rightHeight) + 1;

    }

    public int diameterOfBinaryTree(TreeNode root) {
    
        height(root);
        return this.diameter;
        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i < size; i++){
                TreeNode currNode = queue.poll();
                int leftHeight = 0;
                int rightHeight = 0;

                if(currNode.left != null){
                    leftHeight = height(currNode.left);
                    queue.add(currNode.left);
                }

                if(currNode.right != null){
                    rightHeight = height(currNode.right);
                    queue.add(currNode.right);
                }

                ans = Math.max(ans, leftHeight+rightHeight);
            }
        }
        
        return ans;
        */
    }
}