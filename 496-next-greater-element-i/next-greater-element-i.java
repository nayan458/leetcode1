// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {

//         Map<Integer, Integer> hm = new HashMap<>();
//         Stack<Integer> s = new Stack<>();

//         for(int i = 0; i < nums2.length; i++) {
//             while(!s.isEmpty() && nums2[i] > s.peek()) {
//                 hm.put(s.pop(),nums2[i]);
//             }
//             s.push(nums2[i]);
//         }

//         while(!s.isEmpty()) 
//             hm.put(s.pop(),-1);

//         for(int i = 0; i < nums1.length; i++)
//             nums1[i] = hm.get(nums1[i]);

//         return nums1;
//     }
// }

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

            // int j = 0;
            // for(j = 0; j < nums2.length; j++) {
            //     if(nums2[j] == elem)
            //         break;
            // }

            for(int j = indexInNums2; j < nums2.length; j++) {
                if(nums2[j] > elem){
                    nums1[i] = nums2[j];
                    break;
                }
            }
        }
        return nums1;    
    }
}