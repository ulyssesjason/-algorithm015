class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        
        traverse(n, 0, 0, "", results);
        
        return results;
    }
    
    private void traverse(int n, int open, int close, String temp, List<String> results){
        if(temp.length() == n * 2){
            results.add(temp);
            return;
        }
        
        if(open < n){
            traverse(n, open+1, close, temp+"(", results);
        }
        if(close < open){
            traverse(n, open, close+1, temp+")", results);
        }
    }
}
