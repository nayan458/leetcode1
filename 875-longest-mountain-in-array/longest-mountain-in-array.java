class Solution {
    public int longestMountain(int[] arr) {
        int max = 0, n = arr.length;
        int i = 1;
        while(i < n - 1){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]){
                int left = i;
                int right = i;
                while(left > 0 && arr[left] > arr[left - 1])
                    left--;
                while(right < n - 1 && arr[right] > arr[right + 1])
                    right++;
                System.out.println("left: " + left + "right: " + right + "i: " + i);
                max = Math.max(max, right - left + 1);
                i = right;
            } else {
                i++;
            }
        }
        return max;
    }
}