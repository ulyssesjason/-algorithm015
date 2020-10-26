class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, (int[] a1, int[] a2) -> Integer.compare(a1[0], a2[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        
        for(int i = 1 ; i < intervals.length ; i++){
            int[] last = list.get(list.size() - 1);
            
            if(intervals[i][0] <= last[1]){
                last[1] = Math.max(intervals[i][1], last[1]);
            }else{
                list.add(intervals[i]);
            }
        }
        
        int[][] rets = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++){
            rets[i] = list.get(i);
        }
        return rets;
    }
}
