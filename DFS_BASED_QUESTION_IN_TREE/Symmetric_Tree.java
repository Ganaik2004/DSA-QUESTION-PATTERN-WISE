class Solution {
    public boolean util(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null|| q==null){
            return false;
        }
        return p.val==q.val && util(p.left,q.right) && util(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return util(root.left,root.right);
    }
}