class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i = n - 1, j = 0;

        while(i>=0 && colors[0] == colors[i])
            i--;
        while(j < n && colors[j] == colors[n-1])
            j++;

        return Math.max(i,n-1-j);
    }
}