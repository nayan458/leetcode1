import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        StringBuilder st = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (int i = s.length() - 1; i >= 0; --i)
            hm.putIfAbsent(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) 
                continue;

            while (st.length() > 0 && st.charAt(st.length() - 1) > s.charAt(i) && hm.get(st.charAt(st.length() - 1)) > i) {
                    set.remove(st.charAt(st.length() - 1));
                    st.deleteCharAt(st.length() - 1);
            }

            set.add(s.charAt(i));
            st.append(s.charAt(i));
        }

        return st.toString();
    }
}
