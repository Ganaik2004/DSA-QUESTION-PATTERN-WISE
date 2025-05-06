class Solution {
    public TreeNode util(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> hm){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hm.get(preorder[preStart]);
        int inLeft = inRoot-inStart;
        root.left = util(preorder,preStart+1,preStart+inLeft,inorder,inStart,inRoot-1,hm);
        root.right = util(preorder,preStart+inLeft+1,preEnd,inorder,inRoot+1,inEnd,hm);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = util(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
        return root;
    }
}