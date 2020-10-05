class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] states = new int[row][col];
        states[0][0] = grid[0][0];
        
        for(int i = 1 ; i < row ; i++){
            states[i][0] = states[i-1][0] + grid[i][0];
        }
        for(int i = 1 ; i < col ; i++){
            states[0][i] = states[0][i-1] + grid[0][i];
        }
        
        for(int i = 1 ; i < row ; i++){
            for(int j = 1 ; j < col ; j++){
                states[i][j] = Math.min(states[i-1][j], states[i][j-1]) + grid[i][j];
            }
        }
        
        return states[row-1][col-1];
    }
}
