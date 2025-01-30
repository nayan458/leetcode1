class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums2.length; i++)
            hm.put(nums2[i],i);
        
        System.out.println(hm);
        for(int i = 0; i < nums1.length; i++){
            
            int indexInNums2 = hm.get(nums1[i]);    // get the index of the element in the array nums2
            int elem = nums1[i];
            nums1[i] = -1;

            System.out.println(indexInNums2);

            for(int j = indexInNums2; j < nums2.length; j++) {

                if(nums2[j] > elem){
                    nums1[i] = nums2[j];
                    break;
                }
                // System.out.printf("nums2[j]: %d %t elem")
            }
        }
        return nums1;    
    }
}