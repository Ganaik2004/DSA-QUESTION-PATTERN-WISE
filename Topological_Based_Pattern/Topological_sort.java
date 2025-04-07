class Solution {
    public static void indeg(ArrayList<ArrayList<Integer>> adj,int indeg[]){
        for(int i  = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                int nei = adj.get(i).get(j);
                indeg[nei]++;
            }
        }
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int ed[] : edges){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
           
        }
        int indeg[] = new int[V];
        indeg(adj,indeg);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            arr.add(curr);
            for(int i = 0;i<adj.get(curr).size();i++){
                int nei = adj.get(curr).get(i);
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        return arr;
    }
}