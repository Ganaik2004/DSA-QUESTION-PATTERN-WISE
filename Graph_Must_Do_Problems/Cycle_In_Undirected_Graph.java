class Solution {
    public boolean util(ArrayList<ArrayList<Integer>> adj,boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i = 0;i<adj.get(curr).size();i++){
            int nei = adj.get(curr).get(i);
            if(!vis[nei]){
                if(util(adj,vis,nei,curr)){
                    return true;
                }
            }else if(vis[nei] && nei!=par){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(util(adj,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
        
    }
}