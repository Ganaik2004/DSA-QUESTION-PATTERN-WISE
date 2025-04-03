class Solution {
    public static void util(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> arr,Node root){
        if(root.left==null && root.right==null){
            arr.add(root.data);
            adj.add(new ArrayList<>(arr));
            arr.remove(arr.size()-1);
            return ;
        }
        if(root.left!=null){
            arr.add(root.data);
            util(adj,arr,root.left);
            arr.remove(arr.size()-1);
        }
        if(root.right!=null){
            arr.add(root.data);
            util(adj,arr,root.right);
            arr.remove(arr.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        util(adj,arr,root);
        return adj;
    }
}
