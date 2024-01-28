class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minheapStart = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minheapEnd = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(int i=0; i < intervals.length; i++){
            minheapStart.add(new int[]{intervals[i][0], i});
            minheapEnd.add(new int[]{intervals[i][1], i});
        }
        
        int[] result = new int[intervals.length];
        for(int i=0; i < intervals.length; i++)
            result[i] = -1;
        
        while(!minheapEnd.isEmpty()){
            int[] currEnd = minheapEnd.poll();
            int currEndVal = currEnd[0];
            int currEndIdx = currEnd[1];
            while(!minheapStart.isEmpty() && currEndVal > minheapStart.peek()[0])
                minheapStart.poll();
            if(minheapStart.isEmpty())
                return result;
            result[currEndIdx] = minheapStart.peek()[1];
        }
        return result;
    }
}