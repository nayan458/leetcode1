class Solution {
    private static final int[] square;
    private static final Set<Integer> set;
    static {
        square = new int[251];
        set = new HashSet<>();
        for(int i = 0; i < 251; i++) {
            square[i] = i*i;
            set.add(square[i]);
        }
    }
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i+1; j <= n; j++) 
                if(isTriplate(i,j,n))   count++;
        return count * 2;
    }

    private boolean isTriplate(int a, int b, int n) {
        int c = square[a] + square[b];
        if(set.contains(c) && Math.sqrt(c) <= n)
            return true;
        return false;

            
    }
}

