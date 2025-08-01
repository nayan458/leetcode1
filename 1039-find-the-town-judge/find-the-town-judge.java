class Solution {
    int[] outdegree = new int[1_001];
    int[] indegree = new int[1_001];

    public int findJudge(int n, int[][] trust) {
        if(n == 1) return 1;
        int node = -1;

        for(int[] relationship: trust){
            if(node == relationship[0])
                return -1;
            outdegree[relationship[0]]++;
            indegree[relationship[1]]++;
            if(outdegree[relationship[1]] == 0 && indegree[relationship[1]] == n-1)
                node = relationship[1];
        }

        return node;
    }
}