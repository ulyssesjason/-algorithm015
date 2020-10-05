class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if(row == 0){
            return 1;
        }
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        
        int[][] states = new int[row][col];
        
        states[0][0] = 1;
        
        for(int i = 0 ; i < row ; i++){
            if(obstacleGrid[i][0] == 1){
                states[i][0] = 0;
                break;
            }else{
                states[i][0] = 1;
            }
        }
        for(int i = 0 ; i < col ; i++){
            if(obstacleGrid[0][i] == 1){
                states[0][i] = 0;
                break;
            }else{
                states[0][i] = 1;
            }
        }
        for(int i = 1 ; i < row ; i++){
            for(int j = 1 ; j < col ; j++){
                if(obstacleGrid[i][j] == 1){
                    states[i][j] = 0;
                }else{
                    states[i][j] = states[i-1][j] + states[i][j-1];
                }
            }
        }
        return states[row-1][col-1];
    }
}
