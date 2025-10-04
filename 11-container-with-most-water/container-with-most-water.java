class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int curr = height[l+1];
        int l_max = height[l];
        int r_max = height[r];
        int maxWater = 0;
        int curMax = Math.min(l_max,r_max) * (r-l);

        while(l < r){
            if(l_max <= r_max){
                curr = l_max;
                while(curr <= l_max && l < r){
                    curr = height[++l];
                }
                l_max = Math.max(curr, l_max);
                curMax = Math.max(curMax, Math.min(l_max,r_max) * (r-l));
            } else {
                curr = r_max;
                while(curr <= r_max && l < r){
                    curr = height[--r];
                }
                r_max = Math.max(curr, r_max);
                curMax = Math.max(curMax, Math.min(l_max,r_max) * (r-l));
            }
        }
        return curMax;
    }
}