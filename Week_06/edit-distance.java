class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        
        int[][] states = new int[m][n];
        states[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
            
        for(int i = 1 ; i < m ; i++){
            if(word1.charAt(i) == word2.charAt(0) && states[i-1][0] == i){
                states[i][0] = i;
            }else{
                states[i][0] = states[i-1][0] + 1;
            }
        }

        for(int i = 1 ; i < n ; i++){
            if(word1.charAt(0) == word2.charAt(i) && states[0][i-1] == i){
                states[0][i] = i;
            }else{
                states[0][i] = states[0][i-1] + 1;
            }
        }
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    states[i][j] = states[i-1][j-1];
                }else{
                    states[i][j] = Math.min(states[i-1][j], Math.min(states[i][j-1], states[i-1][j-1])) + 1;
                }
            }
        }
            
        return states[m-1][n-1];
    }
}
