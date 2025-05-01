class Solution {

    public int water(int h1, int h2,int d) {
        return Math.min(h1,h2) * d;
    }

    public int maxArea(int[] height) {
        int max_water = 0, curr_water = 0, d = height.length - 1;
        int l = 0, r = d;
        while(l < r) {
            curr_water = water(height[l], height[r], d--);
            if(curr_water > max_water)
                max_water = curr_water;
            if(height[l] <= height[r])
                l++;
            else
                r--;
        }

        return max_water;
        
    }
}