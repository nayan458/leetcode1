class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,List<Integer>> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int N = nums.length;
        for(int i = 0; i < nums.length; i++)
            hm.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);

        for(Map.Entry<Integer, List<Integer>> entry: hm.entrySet()) {
            List<Integer> idxs = entry.getValue();
            int n = idxs.size();

            if(n == 1) { nums[idxs.get(0)] = -1; continue;}
            
            for(int i = 0; i < n; i++){
                int currIdx = idxs.get(i);
                int left = idxs.get((i+n-1) % n);
                int right = idxs.get((i+1)%n);

                int leftDiff = Math.min(Math.abs(currIdx - left),Math.abs(N - Math.abs(currIdx - left)));
                int rightDiff = Math.min(Math.abs(currIdx - right),Math.abs(N - Math.abs(currIdx - right)));

                nums[currIdx] = Math.min(leftDiff,rightDiff);
            }
        }

        for(int query: queries)
            ans.add(nums[query]);
        return ans;
    }
}