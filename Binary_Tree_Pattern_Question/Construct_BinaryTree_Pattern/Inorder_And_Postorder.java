class Solution {
    public TreeNode util(int inorder[],int instart,int inend,int postorder[],int poststart,int postend,HashMap<Integer,Integer> hm){
        if(instart>inend || postend>poststart){
            return null;
        }
        TreeNode root = new TreeNode(postorder[poststart]);
        int inroot = hm.get(postorder[poststart]);
        int inleft = inroot-instart;
        root.left = util(inorder,instart,inroot-1,postorder,postend+inleft-1,postend,hm);
        root.right = util(inorder,inroot+1,inend,postorder,poststart-1,postend+inleft,hm);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = util(inorder,0,inorder.length-1,postorder,postorder.length-1,0,hm);
        return root;
    }
}