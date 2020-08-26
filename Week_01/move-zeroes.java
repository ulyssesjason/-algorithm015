class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length-1 ;i++){

            if(nums[i] != 0){
                continue;
            }
            
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j] != 0){
                    swap(nums, i, j);
                    break;
                }
            }
        }
        
        
    }
    
    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
