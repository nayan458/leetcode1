class Solution {
    public int mirrorDistance(int n) {
        StringBuilder str = new StringBuilder(Integer.toString(n));
        long strl = Long.parseLong(str.reverse().toString());
        long diff = strl - (n * 1L);
        return (int)Math.abs(diff);
    }
}