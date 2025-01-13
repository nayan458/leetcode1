class Solution {

    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort with lambda expressions
      
      Arrays.sort(arr, (a, b) -> Integer.compare(a[col],b[col])); // increasing order
        
    }

    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int arr[][] = new int [size][2];

        for(int i = 0; i < size; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        sortbyColumn(arr,0);

        int beg = 0, end = size - 1;

        while(beg < end){
            int rslt = arr[beg][0] + arr[end][0];
            if( rslt < target)
                ++beg;
            else if( rslt > target)
                --end;
            else
                break;
        }
        int rsltInd[]  = new int[2];
        rsltInd[0] = arr[beg][1];
        rsltInd[1] = arr[end][1];

        return rsltInd;
    }
}