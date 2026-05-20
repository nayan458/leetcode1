class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int count = 0, n = A.length;
        Map<Integer,Integer> hm = new HashMap<>(n);
        int[] C = new int[n];

        for(int i = 0; i < n; i++) {
            hm.put(A[i], hm.getOrDefault(A[i],0) + 1);
            hm.put(B[i], hm.getOrDefault(B[i],0) + 1);

            if(hm.get(A[i]) == 2) count++;
            if(hm.get(B[i]) == 2 && A[i] != B[i]) count++;

            C[i] = count;
        }

        return C;
    }
}