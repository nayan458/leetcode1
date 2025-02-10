// class Solution {

//     public int gcd(int a, int b)
//     {
//         // Everything divides 0
//         if (a == 0)
//             return b;
//         if (b == 0)
//             return a;

//         // Base case
//         if (a == b)
//             return a;

//         // a is greater
//         if (a > b)
//             return gcd(a - b, b);
//         return gcd(a, b - a);
//     }

//     public boolean hasGroupsSizeX(int[] deck) {
//         Map <Integer, Integer> hm = new HashMap<Integer,Integer>();

//         for(int i = 0; i < deck.length; i++)
//             hm.put(deck[i], hm.getOrDefault(deck[i],0) + 1);
        
//         Iterator<Map.Entry<Integer, Integer>> iterator = hm.entrySet().iterator();
//         Map.Entry<Integer, Integer> elem = iterator.next();
//         int a = elem.getValue();
//         int result = a;

//         while(iterator.hasNext()) {
//             elem = iterator.next();
//             int b = elem.getValue();
//             result = gcd(result,b);
//             a = b;
//         }

//         return result > 1 ? true : false;

//     }
// }




























class Solution {
    static int __gcd(int a, int b)  
    {  
        return b == 0? a:__gcd(b, a % b);     
    }
    static int GcdOfArray(int[] arr, int idx)
    {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int a = arr[idx];
        int b = GcdOfArray(arr, idx + 1);
        return __gcd(
            a, b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap <Integer,Integer> freq = new HashMap <>();
        int i = 0, n = deck.length, c=0;
        for(i = 0; i<n; i++){
            freq.put(deck[i],freq.getOrDefault(deck[i],0)+1);
        }
    
        int flag=0;
        int []f =new int[freq.size()];
        i=0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            f[i++]=entry.getValue();
        }
        int gcd=GcdOfArray(f,0);
        if(gcd<=1)
            return false;    
        return true;
    }
}