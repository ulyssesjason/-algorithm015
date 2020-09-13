class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        Set<List<Integer>> results = new HashSet<>();
        
        traverse(nums, new ArrayList<Integer>(), results);
        
        return new ArrayList<>(results);
    }
    
    private void traverse(int[] nums, List<Integer> temp, Set<List<Integer>> results){
        if(temp.size() == nums.length){
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            traverse(nums, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}
