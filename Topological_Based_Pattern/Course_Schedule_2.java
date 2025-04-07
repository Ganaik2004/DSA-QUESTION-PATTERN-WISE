class Solution {
    public void indeg( ArrayList<ArrayList<Integer>> adj,int indeg[]){
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(i).size();j++){
                int nei = adj.get(i).get(j);
                indeg[nei]++;
            }
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        indeg(adj,indeg);
        Queue<Integer> q= new LinkedList<>();
        for(int i = 0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            arr.add(curr);
            for(int i = 0;i<adj.get(curr).size();i++){
                int nei= adj.get(curr).get(i);
                indeg[nei]--;
                if(indeg[nei]==0){
                    q.add(nei);
                }
            }
        }
        int result[] = new int[arr.size()];
        if(arr.size()==numCourses){
            for(int i = 0;i<arr.size();i++){
                result[i] = arr.get(i);
            }
            return result;
        }else{
            return new int[]{};
        }
    }
}