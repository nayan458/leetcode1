class Solution {
    public int smallestRepunitDivByK(int k) {
        if((k & 1) == 0)
            return -1;

        Set<Integer> st = lastDigit(k);

        if(!st.contains(1))
            return -1;
        int i = 1;
        int count = 0;

        while(i % k != 0 || count < Integer.MAX_VALUE){
            if(i % k == 0)
                return ++count;
            i = (((i * 10) % k) + 1) % k;
            count++;
        }
        return -1;
    }
    private Set<Integer> lastDigit(int k){
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < 11; i++)
            set.add((k*i) % 10);
        return set;
    }
}