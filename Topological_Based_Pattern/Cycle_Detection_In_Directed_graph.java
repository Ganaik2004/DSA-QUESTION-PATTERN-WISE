class Solution {
    public boolean util(ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean stack[],int curr){
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0;i<adj.get(curr).size();i++){
            int nei = adj.get(curr).get(i);
            if(!stack[nei]){
                if(util(adj,vis,stack,nei)){
                    return true;
                }
            }else{
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
        }
        boolean vis[] = new boolean[V];
        boolean stack[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                if(util(adj,vis,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }
}