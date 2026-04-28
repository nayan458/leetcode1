class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, i = 0;

        int[] arr = new int[m*n];

        for(int[] row: grid)
            for(int elem: row)
                arr[i++] = elem;
            
        Arrays.sort(arr);

        if(!isNotPossible(arr, x)) return -1;

        int r = arr.length;
        int mid = r/2;
        int opp = calcOpp(arr,mid,x);
        // if(r % 2 == 0)
        //     opp = Math.min(opp,calcOpp(arr,mid-1,x));
        return opp;
    }

    private int calcOpp(int[] arr, int mid, int x) {
        int midElem = arr[mid];
        int opp = 0;
        for(int elem: arr)
            opp += (int)(Math.abs(elem - midElem) / x);
        return opp;
    }

    private boolean isNotPossible(int[] arr, int x) {
        if(x == 1) return true;
        int remainder = arr[0] % x;
        for(int elem: arr)
            if(elem % x != remainder) return false;
        return true;
    }
}
