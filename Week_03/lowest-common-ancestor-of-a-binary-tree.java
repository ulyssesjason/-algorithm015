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
    
        boolean pInLeft = isInSubtree(root.left, p);
        boolean qInLeft = isInSubtree(root.left, q);
        boolean pInRight = isInSubtree(root.right, p);
        boolean qInRight = isInSubtree(root.right, q);
        
        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left, p, q);
        }else if(pInRight && qInRight){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
    
    private boolean isInSubtree(TreeNode node, TreeNode target){
        if(node == target){
            return true;
        }
        if(node == null){
            return false;
        }
        
        return isInSubtree(node.left, target) || isInSubtree(node.right, target);
        
    }
}
