class Solution {
    void util(int row,int col,int nrow[],int ncol[],boolean vis[][],int grid[][],ArrayList<String> list,int row0,int col0){
        vis[row][col] =true;
        int n = grid.length;
        int m = grid[0].length;
        list.add(toString(row-row0,col-col0));
        for(int i = 0;i<4;i++){
            int r = row+nrow[i];
            int c = col+ncol[i];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && grid[r][c]==1){
                util(r,c,nrow,ncol,vis,grid,list,row0,col0);
            }
        }
    }
     String toString(int r,int c){
         return Integer.toString(r)+" "+Integer.toString(c);
     }
    int countDistinctIslands(int[][] grid) {
      int n = grid.length;
      int m = grid[0].length;
      int nrow[] = {-1,0,1,0};
      int ncol[] = {0,1,0,-1};
      boolean vis[][] = new boolean[n][m];
      HashSet<ArrayList<String>> hs = new HashSet<>();
      for(int i = 0;i<n;i++){
          for(int j = 0;j<m;j++){
              if(!vis[i][j] && grid[i][j] == 1){
                  ArrayList<String> list = new ArrayList<>();
              util(i,j,nrow,ncol,vis,grid,list,i,j);
              hs.add(list); 
              }
             
          }
      }
      return hs.size();
    }
}