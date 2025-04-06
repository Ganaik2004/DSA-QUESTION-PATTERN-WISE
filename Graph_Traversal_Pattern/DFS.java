class Solution {
    public void util(ArrayList<ArrayList<Integer>> adj, boolean vis[],int curr,ArrayList<Integer> arr){
        vis[curr] = true;
        arr.add(curr);
        for(int i = 0;i<adj.get(curr).size();i++){
            int nei = adj.get(curr).get(i);
            if(!vis[nei]){
                util(adj,vis,nei,arr);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        for(int i = 0;i<adj.size();i++){
            if(!vis[i]){
                util(adj,vis,i,arr);
            }
        }
        return arr;
        
    }
}