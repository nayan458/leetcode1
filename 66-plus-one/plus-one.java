class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        digits[n-1] += 1;

        for(int i = n - 1; i >= 0; i--){
            digits[i] += carry;
            carry = (digits[i]/10);
            digits[i] = (digits[i] % 10);
            if(carry == 0)
                return digits;
        }
        
        int[] ans = new int[n+1];
        ans[0] = 1;
        for(int i = 0; i < n; i++)
            ans[i+1] = digits[i];
        return ans;
    }
}
