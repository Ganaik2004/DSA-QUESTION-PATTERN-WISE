class Solution {
    public void indeg(ArrayList<ArrayList<Integer>> adj,int indeg[]){
             for(int i = 0;i<adj.size();i++){
                for(int j  = 0;j<adj.get(i).size();j++){
                    int nei = adj.get(i).get(j);
                    indeg[nei]++;
                }
             }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
          adj.add(new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int indeg[] = new int[numCourses];
        indeg(adj,indeg);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indeg.length;i++){
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
        if(numCourses==arr.size()){
            return true;
        }else{
            return false;
        }

     
    }
}