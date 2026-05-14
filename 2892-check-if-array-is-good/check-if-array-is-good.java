class Solution {
    

    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] visited = new int[n];

        for(int num: nums) {
            if(num > n-1 || (visited[num] == 1 && num != n-1) || (num == n-1 && visited[num] == 2)) return false;
            visited[num]++;
        }
        return true;
    }
}
