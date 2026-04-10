class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,ArrayList<Integer>> hm = new HashMap<>();

        int distance = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++)
            hm.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        
        for(ArrayList<Integer> indxArr: hm.values())
            if(indxArr.size() > 2)
                distance = Math.min(distance, minDist(indxArr));
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    private int minDist(ArrayList<Integer> indxArr) {
        int idx = 0, min = Integer.MAX_VALUE, n = indxArr.size();
        while(idx < n-2) {
            int i = indxArr.get(idx);
            int j = indxArr.get(idx+1);
            int k = indxArr.get(idx+2);
            min = Math.min(min, (Math.abs(j - i) + Math.abs(k - j) + Math.abs(k - i)));
            idx++;
        }
        return min;
    }
}