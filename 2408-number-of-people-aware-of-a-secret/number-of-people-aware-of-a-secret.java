class Solution {
    long[] t;
    long MOD = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        t = new long[n + 1];
        t[1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = i + delay; j < i+forget && j <= n; j++)
                t[j] = (t[j] + t[i]) % MOD;
        }

        long ans = 0;
        for(int i = n - forget + 1; i <= n; i++){
            ans = (ans + t[i]) % MOD;
        }
        
        return (int)(ans % MOD);
    }
}

// class Solution {
//     long n, delay, forget, valid, x;
//     long[] t;
//     long MOD = 1_000_000_007;
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         this.n = n;
//         this.delay = delay;
//         this.forget = forget;
//         this.valid = n - forget;
//         this.t = new long[n+1];
//         this.x = forget - delay;

//         for(int i = 0; i <= n; i++)
//             t[i] = -1;
        

//         return (int)(dp(1) % MOD);
//     }
//     private long dp(long day){
//         if(day > n)
//             return 0;
//         long count = 0;
//         if(day > valid)
//             count++;
//         for(long i = 0; i < x; i++){
//             long new_day = (i+day+delay);
//             if(new_day > n)
//                 break;
//             if(t[(int)new_day] != -1)
//                 count = ((count + t[(int)new_day]) % MOD);
//             else{
//                 t[(int)new_day] = dp(new_day) % MOD;
//                 count += t[(int)new_day] % MOD;
//             }
//         }
//         return t[(int)day] = count % MOD;
//     }
// }

// // recursive approach
// class Solution {
//     long n, delay, forget, valid, x;
//     long[] t;
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         this.n = n;
//         this.delay = delay;
//         this.forget = forget;
//         this.valid = n - forget;
//         this.t = new long[n+1];
//         this.x = forget - delay;

//         for(int i = 0; i <= n; i++)
//             t[i] = -1;

//         return (int)(dp(1) % 1_000_000_007);
//     }
//     private long dp(long day){
//         if(day > n)
//             return 0;
//         int count = 0;
//         if(day > valid)
//             count++;
//         for(long i = 0; i < x; i++){
//             long new_day = (i+day+delay);
//             if(new_day > n)
//                 break;
//             count += dp(new_day);
//         }
//         return count;
//     }
// }

// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         int mod = 1_000_000_007;
//         int x = forget - delay;
//         int valid = n - forget;
//         Queue<Integer> q = new LinkedList<>();
//         q.add(1);
//         int count = 0;
//         while(!q.isEmpty()){
//             int elem = q.poll();
//             if(elem > valid){
//                 count++;
//             }
//             for(int i = 0; i < x; i++){
//                 if(i+elem+delay > n)
//                     break;
//                 q.add(i+elem+delay);

//             }
//         }
//         return count;
//     }