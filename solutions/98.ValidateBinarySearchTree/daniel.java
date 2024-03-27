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

    public void recursion(TreeNode root, List<Integer> inorder){

        if(root == null){
            return;
        }

        recursion(root.left,inorder);
        inorder.add(root.val);
        recursion(root.right,inorder);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root,list);
        if(list.size() == 1){
            return true;
        }
        for(int i =1; i < list.size(); i++){
            if(list.get(i-1) >= list.get(i)){
                return false;
            }
        }
        return true;
  
    }
}