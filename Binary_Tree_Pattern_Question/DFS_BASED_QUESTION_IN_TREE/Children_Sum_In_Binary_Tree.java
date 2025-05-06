class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        if(root==null){
            return 1;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int total = 0;
        if(root.left!=null){
            total+=root.left.data;
        }
         if(root.right!=null){
            total+=root.right.data;
        }
        if(total!=root.data){
            return 0;
        }
        if( isSumProperty(root.left)==1 && isSumProperty(root.right)==1){
            return 1;
        }else{
            return 0;
        }
    }
}