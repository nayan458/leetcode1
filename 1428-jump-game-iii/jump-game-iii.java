class Solution {
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return dp(arr,start+1);
    }

    private boolean dp(int[] arr, int idx) {
        if(idx <= 0 || idx > arr.length) return false;
        if(visited[idx-1]) return false;
        if(arr[idx-1] == 0) return true;
        visited[idx-1] = true;
        return dp(arr, idx-arr[idx-1]) || dp(arr,idx+arr[idx-1]);
    }
}