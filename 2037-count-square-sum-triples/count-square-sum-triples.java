class Solution {
    
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++)
            for(int j = i+1; j <= n; j++) 
                if(isTriplate(i,j,n))   count++;
        return count * 2;
    }

    private boolean isTriplate(int a, int b, int n) {
        double c = Math.sqrt(((a*a) + (b*b)));
        if(c == Math.floor(c) && c <= n)
            return true;
        return false;

            
    }
}

