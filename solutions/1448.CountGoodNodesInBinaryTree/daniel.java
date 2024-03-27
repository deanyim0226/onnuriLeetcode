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
    private int count;
    
    public void recursion(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.val);

        if(Collections.max(path) <= path.get(path.size()-1)){
            count += 1;
        }
   
        recursion(root.left,path);
        recursion(root.right,path);
        path.remove(path.size()-1);
       
    }
    
    public int goodNodes(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        //keep track of maxvalue 
        recursion(root,list);
        return count;
    }
}