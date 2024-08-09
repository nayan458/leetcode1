class Solution {
    
    // itrative

    public int fib(int n) {
        int cur = 0, prev = 1, fib_number = 0;

        if(n == 0)
            return 0;
        while(n > 0){
            fib_number = cur + prev;
            prev = cur;
            cur = fib_number;
            n--;
        }

        return fib_number;
    }

    // recursive

        // public int fib(int n) {
        //     if(n == 0)
        //         return 0;
        //     if(n == 1)
        //         return 1;
        //     return fib(n-1) + fib(n-2);
        // }
    
}