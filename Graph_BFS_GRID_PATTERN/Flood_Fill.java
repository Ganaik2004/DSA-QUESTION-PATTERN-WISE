class Solution {
    public class pair{
        int row;
        int col;
        int dis;
        public pair(int row,int col,int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        int nrow[] = {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j]==0){
                      vis[i][j] = true;
                      q.add(new pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dis;
            q.remove();
            mat[row][col] = dis;
            for(int i = 0;i<4;i++){
                int r = row+nrow[i];
                int c = col+ncol[i];
                if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && mat[r][c]==1){
                    q.add(new pair(r,c,dis+1));
                    vis[r][c] = true;
                }
            }
        }
        return mat;
    }
}