class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if(m == 0 || n == 0){
            return 0;
        }
        
        int[][] states = new int[m][n];
        
        states[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        
        for(int i = 1 ; i < m ; i++){
            if(text1.charAt(i) == text2.charAt(0)){
                states[i][0] = 1;
            }else{
                states[i][0] = states[i-1][0];
            }
        }
        
        for(int i = 1 ; i < n ; i++){
            if(text1.charAt(0) == text2.charAt(i)){
                states[0][i] = 1;
            }else{
                states[0][i] = states[0][i-1];
            }
        }
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    states[i][j] = states[i-1][j-1] + 1;
                }else{
                    states[i][j] = Math.max(states[i-1][j], states[i][j-1]);
                }
            }
        }
        
        return states[m-1][n-1];
    }
}
