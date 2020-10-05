class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int size = nums.length;
        
        int[] states = new int[size];
        states[0] = nums[0];
        states[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2 ; i < size ; i++){
            states[i] = Math.max(states[i-1], states[i-2] + nums[i]);
        }
        
        return states[size-1];
    }
}
