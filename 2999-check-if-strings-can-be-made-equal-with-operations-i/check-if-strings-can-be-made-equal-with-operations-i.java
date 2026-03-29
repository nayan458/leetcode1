class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[] odd = new int[32];
        int[] even = new int[32];

        for(int i = 0; i < s1.length(); i++) {
            if(i%2 == 0){
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
            else {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
        }

        for(int i = 0; i < 32; i++)
            if(even[i] != 0 || odd[i] != 0)
                return false;

        return true;
    }
}