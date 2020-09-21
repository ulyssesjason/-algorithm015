class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] D = new int[][]{{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
        
        int row = board.length;
        if(row == 0){
            return board;
        }
        int col = board[0].length;
        
        boolean[] visited = new boolean[row * col];
        Queue<Integer> queue = new LinkedList<>();
        
        int clicked = click[0] * col + click[1];
        queue.offer(clicked);
        visited[clicked] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            int x = node / col;
            int y = node % col;
            int mines = minesCount(board, x, y, D);
            if(board[x][y] == 'M'){
                board[x][y] = 'X';
                return board;
            }
            
            if(mines > 0){
                board[x][y] = (char)((int)'0' + mines);
            }else{
                for(int i = 0 ; i < 8 ; i++){
                    int nx = x + D[i][0];
                    int ny = y + D[i][1];
                    int nd = nx * col + ny;
                
                    if(nx >= 0 && nx < row && ny >= 0 && ny < col){
                        if(!visited[nd] && board[nx][ny] != 'M'){
                            visited[nd] = true;
                            queue.offer(nd);
                        }
                    }
                }
                board[x][y] = 'B';
            }

        }
        return board;
    }
    
    private int minesCount(char[][] board, int x, int y, int[][] D){
        int mines = 0;
        int row = board.length;
        int col = board[0].length;

        for(int i = 0 ; i < 8 ; i++){
            int nx = x + D[i][0];
            int ny = y + D[i][1];
            int nd = nx * col + ny;
                
            if(nx >= 0 && nx < row && ny >= 0 && ny < col 
               && (board[nx][ny] == 'M' || board[nx][ny] == 'X')){
                mines ++;
            }
       }
       return mines; 
    }
}
