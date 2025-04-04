class Solution {
    public class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public void dfs(char grid[][],boolean vis[][],int row,int col,int nrow[],int ncol[]){
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<4;i++){
            int r = row+nrow[i];
            int c = col+ncol[i];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && grid[r][c]=='1' ){
                dfs(grid,vis,r,c,nrow,ncol);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int nrow[] =  {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
        int count = 0;
       Queue<pair> q= new LinkedList<>();
       for(int i =0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(grid[i][j]=='1'){
                q.add(new pair(i,j));
            }
        }
       }
  
      while(!q.isEmpty()){
        int row = q.peek().row;
        int col = q.peek().col;
        q.remove();
        if(!vis[row][col]){
            count++;
            dfs(grid,vis,row,col,nrow,ncol);
        }
      }
      return count;
    }
}