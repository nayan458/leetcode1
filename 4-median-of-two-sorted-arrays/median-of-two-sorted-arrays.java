class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length,in,i=0,j=0,k=0;
        int merg[]=new int[l1+l2];
        in=(int)((l1+l2)/2);
        while(k<=in && i<l1 && j<l2){
            if(nums1[i]<nums2[j])
                merg[k++]=nums1[i++];
            else
                merg[k++]=nums2[j++];
        }
        while(k<=in){
            if(i<l1)
                merg[k++]=nums1[i++];
            if(j<l2)
                merg[k++]=nums2[j++];
        }
        System.out.println(in);
        for(i=0; i<=in; i++)
            System.out.print(merg[i]);
        if((l1+l2)%2==0)
            return (merg[in]+merg[in-1])/2.0;
        else
            return (double)merg[in];

    }
}