class Solution {
    public static int[][] D = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int count = 0;
        
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * col + j);
                    grid[i][j] = '0';
                    
                    while(!queue.isEmpty()){
                        int node = queue.poll();
                        
                        int x = node / col;
                        int y = node % col;
                        for(int k = 0 ; k < 4; k++){
                            int nx = x + D[k][0];
                            int ny = y + D[k][1];
                            if(nx >= 0 && nx < row && ny >=0 && ny < col && grid[nx][ny] == '1'){
                                queue.offer(nx * col + ny);
                                grid[nx][ny] = '0';
                            }
                        }
                    }
                }   
            }
        }
        
        return count;
    }
}
