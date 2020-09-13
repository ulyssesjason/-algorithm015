class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Set<List<Integer>> results = new HashSet<>();
        
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> tempCounter = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++){
            if(!counter.containsKey(nums[i])){
                counter.put(nums[i], 0);
                tempCounter.put(nums[i], 0);
            }
            counter.put(nums[i], counter.get(nums[i])+1);
        }
        
        traverse(nums, new ArrayList<Integer>(), tempCounter , results, counter);
        
        return new ArrayList<>(results);
    }
    
    private void traverse(int[] nums, List<Integer> temp, Map<Integer, Integer> tempCounter, Set<List<Integer>> results, Map<Integer, Integer> counter){
        
        if(temp.size() == nums.length){
            results.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            if(tempCounter.get(nums[i]) >= counter.get(nums[i])){
                continue;
            }

            temp.add(nums[i]);
            tempCounter.put(nums[i], tempCounter.get(nums[i]) + 1);
            traverse(nums, temp, tempCounter, results,counter);
            temp.remove(temp.size() - 1);
            tempCounter.put(nums[i], tempCounter.get(nums[i]) - 1);
        }
    }
}


