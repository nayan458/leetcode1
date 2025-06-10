class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while( i < m && j < n){
            if(nums1[i] == nums2[j]){
                arr.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j])
                j++;
            else
                i++;
        }
        int rslt[]  = new int[arr.size()];
        for( i = 0; i < arr.size(); i++)
            rslt[i] = arr.get(i);
        return rslt;
    }
}