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

    public void preOrder(TreeNode root, String curr, List<String> list){

        if(root == null){
            return;
        }

        curr += root.val;    
        preOrder(root.left, curr, list);
        preOrder(root.right, curr, list);

        if(root.left == null && root.right == null){
            list.add(curr);
        }

        curr.substring(0,curr.length()-1);
        
    }
    public int sumNumbers(TreeNode root) {
        List<String> list = new ArrayList<>();
        preOrder(root,"", list);
        int ans = 0;

        for(String curr : list){
            ans += Integer.valueOf(curr);
        }

        return ans;
    }
}