class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] states = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++){
            states[s.charAt(i) - 'a'] ++;
            states[t.charAt(i) - 'a'] --;
        }
        
        for(int i : states){
            if(i != 0){
                return false;
            }
        }
        
        return true;
    }
}
