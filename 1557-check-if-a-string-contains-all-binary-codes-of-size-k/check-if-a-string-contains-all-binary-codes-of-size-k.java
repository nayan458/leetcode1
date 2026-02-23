class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = 0;
        boolean[] visited = new boolean[(1 << k)];
        if((s.length() - k) < k) return false;
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
        count++;
        visited[bf.getValue()] = true;
        while(i < s.length()){
            bf.leftShift();
            if(bits[i] == 1)
                bf.setLastBit();
            if(!visited[bf.getValue()]) {
                visited[bf.getValue()] = true;
                count++;
            }
            if(count == (1 << k)) return true;
            i++;
        }
        return count == (1 << k);
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