class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length ;
        int[] rets = new int[size];
        k = k % size;
        
        for(int i = 0 ; i < size ; i++){
            int index = i + k <= size - 1 ? i + k : i + k - size;
            
            rets[index] = nums[i];
        }
     
        for(int i = 0 ; i < size ; i++){
            nums[i] = rets[i];
        }
        
    }
}
