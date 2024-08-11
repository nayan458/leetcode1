class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {        

        // create a temporary array to store the first array
        int temp [] = new int[m];
        for(int i = 0; i < m; i++)
            temp[i] = nums1[i];
        
        // p1 is a pointer to traverse the temp array (i.e a clone of nums1 )
        // p2 is a pointer to traverse the nums2 array
        // i is a pointer to traverse the nums1 array to store the values
        
        int p1 = 0, p2 = 0, i = 0;

        while(p1 < m && p2 < n)
            if(temp[p1] > nums2[p2])
                nums1[i++] = nums2[p2++];
            else
                nums1[i++] = temp[p1++];
            
        // the leftout elements are later inserted into the array
        if(p1 < m)
            while(p1 < m)
                nums1[i++] = temp[p1++];
        else
            while(p2 < n)
                nums1[i++] = nums2[p2++];       
        
    }
}