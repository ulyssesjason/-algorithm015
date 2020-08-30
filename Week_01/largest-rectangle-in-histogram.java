class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int size = heights.length;
        for(int i=0 ; i < size ; i++){
            int min = heights[i];
            for(int j = i ; j < size ; j++){
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j-i+1) * min);
            }
        }
        
        return max;
    }
}
