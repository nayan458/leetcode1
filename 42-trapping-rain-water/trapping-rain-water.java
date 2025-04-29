class Solution {

    public int trap(int[] height) {
        int count = 0;
        int left = 0, right = height.length - 1;
        int lg = height[left], rg = height[right];

        while (left < right) {
            if (lg <= rg) {
                ++left;
                if (height[left] >= lg)
                    lg = height[left];
                else
                    count += lg - height[left];
            }
            else if (rg < lg) {
                --right;
                if (height[right] >= rg)
                    rg = height[right];
                else
                    count += rg - height[right];
            }
            System.out.println(count);
        }
        return count;
    }
}