class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int min = Integer.MAX_VALUE;
        int l = 0, r = min;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(isPossible(mid,jobs,k)) {
                r = mid - 1;
                min = Math.min(mid,min);
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

    private boolean isPossible(int max, int[] jobs, int k) {
        int[] workers = new int[k];
        return backtracking(jobs, workers, jobs.length, max);
    }

    private boolean backtracking(int[] jobs, int[] workers, int idx, int max){
        if(idx == 0)
            return true;
        for(int i = 0; i < workers.length; i++) {
            if(workers[i] + jobs[idx-1] > max) continue;
            workers[i] += jobs[idx-1];
            if(backtracking(jobs,workers,idx-1,max)) return true;
            workers[i] -= jobs[idx-1];
            if(workers[i] == 0) break;
        }
        return false;
    }
}