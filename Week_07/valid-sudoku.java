class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++){
            
            int[] rows = new int[10];
            int[] cols = new int[10];
            
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] != '.'){
                    int row = board[i][j] - '0';
                    rows[row] ++;
                    if(rows[row] > 1){
                        return false;
                    }
                }
                
                if(board[j][i] != '.'){
                    int col = board[j][i] - '0';
                    cols[col] ++;
                
                    if(cols[col] > 1){
                        return false;
                    }
                }
                
            }
        }
        
        for(int i = 0 ; i <= 6 ; i += 3){
            for(int j = 0 ; j <= 6 ; j += 3){
                int[] set = new int[10];
                
                for(int k = 0 ; k < 3 ; k++){
                    for(int l = 0 ; l < 3 ; l++){
                        if(board[i+k][j+l] == '.'){
                            continue;
                        }
                        set[board[i+k][j+l] - '0'] ++;
                        if(set[board[i+k][j+l] - '0'] > 1){
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;

    }
}
