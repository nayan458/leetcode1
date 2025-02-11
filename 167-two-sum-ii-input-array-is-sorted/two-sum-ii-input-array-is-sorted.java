class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1, sum = 0;
        
        while(l<r) {
            sum = numbers[l] + numbers[r];
            if(sum == target)
                return new int[]{l+1, r+1};
            if(sum > target)
                --r;
            else
                ++l;
        }
        
        return new int[]{l+1, r+1};
    }
}








































//         int beg = 0, end = numbers.length - 1;

//         while(beg < end){
//             int rslt = numbers[beg] + numbers[end];
//             if( rslt < target)
//                 ++beg;
//             else if( rslt > target)
//                 --end;
//             else
//                 break;
//         }
//         int rsltInd[]  = new int[2];
//         rsltInd[0] = beg+1;
//         rsltInd[1] = end+1;
//         return rsltInd;
//     }
// }