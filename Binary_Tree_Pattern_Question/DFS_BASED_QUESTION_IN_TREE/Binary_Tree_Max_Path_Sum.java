class Solution {
    int max = Integer.MIN_VALUE;
    public int util(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(0,util(root.left));
        int right = Math.max(0,util(root.right));
        max  = Math.max(root.val+left+right,max);
        return Math.max(left,right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        util(root);
        return max;
    }
}