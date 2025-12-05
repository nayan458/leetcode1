class Solution {
    public int kthFactor(int n, int k) {
        Set<Integer> st = new HashSet<>();
        for(int i = 1; i*i <= n; i++) {
            System.out.print("for elem: " + i + "\n");
            if(n % i == 0) {
                // int e1 = i;
                // int e2 = n/i;
                // System.out.print(e1 + " " + e2 + " " + st + "\n");
                st.add(n/i);
                st.add(i);
            }
        }
        if(st.size() < k)
            return -1;
        System.out.println(st);
        int[] arr = new int[st.size()];
        int i = 0;
        
        for(int elem: st)
            arr[i++] = elem;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr[k-1];
    }
}