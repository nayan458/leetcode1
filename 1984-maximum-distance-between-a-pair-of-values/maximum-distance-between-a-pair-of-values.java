class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j = 1;
        int dist = 0;
        for(int i = 0; i < nums1.length; i++) {
            while(j < nums2.length && nums1[i] <= nums2[j])
                j++;
            dist = Math.max(dist,j-i-1);
        }
        return dist;
    }
}


