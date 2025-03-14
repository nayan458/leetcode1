import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        Stack<Character> st = new Stack<>();
        Set<Character> set = new HashSet<>();
        String str = new String();
        String result = new String();

        for (int i = s.length() - 1; i >= 0; --i) {
            hm.putIfAbsent(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println(set);
            System.out.println(st);
            
            if (set.contains(s.charAt(i)) || (!st.empty() && st.peek() == s.charAt(i))) 
                continue;

            if (st.empty() || st.peek() < s.charAt(i)) {
                st.push(s.charAt(i));
                set.add(s.charAt(i));
            } else {
                while (!st.empty() && st.peek() > s.charAt(i)) {
                    if (hm.get(st.peek()) > i) {
                        set.remove(st.pop());
                    } else {
                        break;
                    }
                }
                set.add(s.charAt(i));
                st.push(s.charAt(i));
            }
        }

        while (!st.empty())
            str += st.pop();

        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }
}
