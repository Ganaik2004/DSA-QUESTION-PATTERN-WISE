class Solution {
    public class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.col = col;
            this.row = row;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sr,sc));
        vis[sr][sc] = true;
        int org = image[sr][sc];
        image[sr][sc] = color;
        int nrow[] = {-1,0,1,0};
        int ncol[] = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            for(int i = 0;i<4;i++){
                int r = row+nrow[i];
                int c = col+ncol[i];
                if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && image[r][c]==org){
                    q.add(new pair(r,c));
                    image[r][c] = color;
                    vis[r][c] = true;
                }
            }
        }
        return image;
    }
}