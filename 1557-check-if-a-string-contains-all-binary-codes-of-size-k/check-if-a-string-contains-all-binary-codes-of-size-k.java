class Solution {
    private final Set<Integer> set = new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k)
            return false;
        int[] bits = s.chars()
              .map(c -> c - '0')
              .toArray();
        BitField bf = new BitField(k, 0);
        for(int i = 0; i < k; i++) {
            bf.leftShift();
            if(bits[i] == 1)
                bf.setLastBit();
        }
        int i = k;
        set.add(bf.getValue());
        while(i < s.length()){
            bf.leftShift();
            if(bits[i] == 1)
                bf.setLastBit();
            set.add(bf.getValue());
            i++;
        }
        // System.out.println(set);
        return set.size() == Math.pow(2,k);
    }
}
class BitField {
    int num;
    int k;

    public BitField(int k, int num) {
        this.k = k;
        this.num = num;
    }
    public void leftShift() {
        num = num << 1;
        num &= ~(1<<k);
    }

    public void setLastBit() {
        num = num | 1;
    }

    public int getValue() {
        return num;
    }
}