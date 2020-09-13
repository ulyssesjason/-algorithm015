class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> results = new HashSet<>();
        
        traverse(n, 1 , k, new ArrayList<Integer>(), results);
        
        return new ArrayList<>(results);
    }
    
    private void traverse(int n, int start, int k, List<Integer> temp, Set<List<Integer>> results){
        if(temp.size() == k){
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start ; i < n+1 ; i++){
            temp.add(i);
            traverse(n, i+1 , k , temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}
