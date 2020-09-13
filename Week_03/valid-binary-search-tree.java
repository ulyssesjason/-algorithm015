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
    
    class Result{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        boolean isBST;
        public Result(boolean isBST){
            this.isBST = isBST;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        
        
        return traverse(root).isBST;
        
    }
    
    private Result traverse(TreeNode node){
        if(node == null){
            return new Result(true);
        }
        
        Result left = traverse(node.left);
        Result right = traverse(node.right);
        
        int min = Math.min(left.min, node.val);
        int max = Math.max(right.max, node.val);
        
        Result result = new Result(false);
        
        result.min = min;
        result.max = max;

        if(left.isBST && right.isBST && node.val > left.max && node.val < right.min){
            result.isBST = true;
        }
        if(node.val == Integer.MAX_VALUE && node.right == null && left.isBST && node.val > left.max){
            result.isBST = true;
        }
        if(node.val == Integer.MIN_VALUE && node.left == null && right.isBST && node.val < right.min){
            result.isBST = true;
        }
        
        return result;
    }
}
