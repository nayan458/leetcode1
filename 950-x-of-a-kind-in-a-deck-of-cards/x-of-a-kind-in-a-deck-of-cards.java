class Solution {
    static int __gcd(int a, int b)  
    {  
        return b == 0? a:__gcd(b, a % b);     
    }
  
// recursive implementation
    static int GcdOfArray(int[] arr, int idx)
    {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int a = arr[idx];
        int b = GcdOfArray(arr, idx + 1);
        return __gcd(
            a, b); // __gcd(a,b) is inbuilt library function
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap <Integer,Integer> freq = new HashMap <>();
        int i = 0, n = deck.length, c=0;
        // if (n%2 !=0)
        //     return false;
        for(i = 0; i<n; i++){
            // if(freq.contains(deck[i])){
                freq.put(deck[i],freq.getOrDefault(deck[i],0)+1);
            // }
        }
        // int min=Integer.MAX_VALUE;
        // for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //     if(entry.getValue()<min)
        //         min=entry.getValue();
        // }
        int flag=0;
        int []f =new int[freq.size()];
        i=0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            f[i++]=entry.getValue();
        }
        int gcd=GcdOfArray(f,0);
        if(gcd<=1)
            return false;
        // System.out.println(gcd);
        // for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //     // if(entry.getValue()!=m ){
        //         if(entry.getValue()%gcd != 0)
        //             return false;
        //         System.out.println( entry.getValue());
                
        // }
            
        
        return true;
    }
}