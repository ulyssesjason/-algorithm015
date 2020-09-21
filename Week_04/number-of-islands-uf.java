class Solution {
    
    class UF{
        int count;
        int[] parent;
        
        public UF(char[][] grid){
            int row = grid.length;
            int col = grid[0].length;
            
            parent = new int[row * col];
            
            for(int i = 0 ; i < row ; i++){
                for(int j = 0 ; j < col ; j++){
                    if(grid[i][j] == '1'){
                        count ++;
                    }
                    parent[i * col + j] = i * col + j;
                }
            }
        }
        
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP != rootQ){
                parent[rootP] = rootQ;
                count --;
            }
        }
        
        public int find(int p){
            while(p != parent[p]){
                p = parent[p];
            }
            return p;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int[][] D = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        
        UF uf = new UF(grid);
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    int node = i * col + j;
                    
                    for(int k = 0 ; k < 4 ; k++){
                        int nx = i + D[k][0];
                        int ny = j + D[k][1];
                        if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == '1'){
                            uf.union(nx * col + ny, node);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
}
