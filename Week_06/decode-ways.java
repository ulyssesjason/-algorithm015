class Solution {
    public int numDecodings(String s) {
        int size = s.length();
        
        int[] states = new int[size + 1];
        
        states[0] = 1;
        states[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2 ; i < size +1; i++){
            if(s.charAt(i - 1) != '0'){
                states[i] += states[i-1];
            }
            if(valid(s,i - 1)){
                states[i] += states[i-2];
            }
        }
        
        return states[size];
    }
    
    private boolean valid(String s, int i){
            String d = s.substring(i-1, i+1);
            int j = Integer.valueOf(d);
            return j >= 10 && j <= 26;
    }
}
