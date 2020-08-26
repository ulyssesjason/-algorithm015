// leetcode 15
// https://leetcode.com/problems/3sum/
// time: O(n^2), space: O(n)
class Solution {
    class Pair{
        int left;
        int right;
        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> rets = new HashSet<>();
        Arrays.sort(nums);
        // divide three sum to one + twoSum (with double pointers)
        
        for(int i = 0 ; i < nums.length - 2 ; i++){
            for( Pair p : twoSum(nums, i+1, - nums[i])){
                rets.add(Arrays.asList(nums[i], p.left, p.right));
            }
        }
        return new ArrayList<>(rets);
    }


    private List<Pair> twoSum(int[] nums, int start, int target){
        List<Pair> rets = new ArrayList<>();
        
        int left = start, right = nums.length - 1;
        
        while(left < right){
            if(nums[left] + nums[right] < target){
                left ++;
            }else if(nums[left] + nums[right] > target){
                right --;
            }else{
                rets.add(new Pair(nums[left], nums[right]));
                left ++;
                right --;
            }
        }
        
        return rets;
    }
}
