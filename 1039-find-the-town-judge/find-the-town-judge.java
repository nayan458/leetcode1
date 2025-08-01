class Solution {
    int[] outdegree = new int[1_001];
    int[] indegree = new int[1_001];

    public int findJudge(int n, int[][] trust) {

        for(int[] relationship: trust){
            outdegree[relationship[0]]++;
            indegree[relationship[1]]++;
        }

        for(int i = 1; i <= n; i++)
            if(outdegree[i] == 0){
                if(indegree[i] < n-1)
                    return -1;
                return i;
            }
        return -1;
    }
}