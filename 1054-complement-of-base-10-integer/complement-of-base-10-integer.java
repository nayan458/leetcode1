class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        int complement = 0;
        for(int i = 0; i < s.length(); i++){
            complement <<= 1;
            if(s.charAt(i) == '0')
                complement |= 1;
        }
        return complement;
    }
}