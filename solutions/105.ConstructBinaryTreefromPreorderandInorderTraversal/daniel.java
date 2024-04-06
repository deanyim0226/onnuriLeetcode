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
    private int index;
    public TreeNode recursion(int[] preorder, HashMap<Integer,Integer> map, int left, int right){

        if(left > right){
            return null;
        }else{
            
            int currVal = preorder[index];
            TreeNode root = new TreeNode(currVal);
            index+=1;

            root.left = recursion(preorder,map, left, map.get(currVal)-1);
            root.right = recursion(preorder,map, map.get(currVal)+1, right);

            return root;
        }
  
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        /*
        preorder starts with root 
        since we know the root of tree, we can determine the tree by comparing preorder and inorder
        3 9 20 15 7
        9 [3] 15 20 7
        */
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }

        return recursion(preorder,map,0,preorder.length-1);
   
    }
}