class Solution {
    private int[] visited;

    public boolean isGood(int[] nums) {
        int n = nums.length;
        this.visited = new int[n];

        for(int num: nums) {
            if(num > n-1 || (visited[num] == 1 && num != n-1) || (num == n-1 && visited[num] == 2)) return false;
            visited[num]++;
        }

        return true;
    }
}
