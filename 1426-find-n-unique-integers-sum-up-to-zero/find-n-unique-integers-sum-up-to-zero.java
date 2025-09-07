class Solution {
    public int[] sumZero(int n) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n / 2; i++) {
            ans.add(i + 1);          // add positive numbers
            ans.add(-(i + 1));       // add negative numbers
        }
        
        if (n % 2 != 0) ans.add(0);  // add 0 if n is odd
        
        int[] obj = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            obj[i] = ans.get(i);     // unbox Integer -> int
        }
        return obj;
    }
}
