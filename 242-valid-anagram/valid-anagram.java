// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length()!= t.length())
//             return false;
//         HashMap<Character,Integer> hm = new HashMap<>();
//         for(int i=0; i<s.length(); i++){
//             // if(hm.getOrDefault(s.charAt(i),1)>0){
//                 int temp=0;
//                 temp=hm.getOrDefault(s.charAt(i),0);
//                 hm.put(s.charAt(i),++temp);
//             // }
                
//         }
//         System.out.println(hm);
//         for(int i=0; i<s.length(); i++){
//             if(hm.containsKey(t.charAt(i))){
//                 int temp = hm.get(t.charAt(i));
//                 hm.put(t.charAt(i),--temp);
//                 if(temp <= 0)
//                     hm.remove(t.charAt(i));
//                 continue;
//             }
//             break;
//         }
//         System.out.println(hm);
//         if(hm.size() == 0){
//             return true;
//         }
        
//         return false;
//     }
// }
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> frequencyCount = new HashMap<>();
        int n = s.length(), m = t.length();
        if(n != m)
            return false;
        for(int i = 0; i < n; i++)
            frequencyCount.put(s.charAt(i),frequencyCount.getOrDefault(s.charAt(i),0)+1);
        int count = 0;
        for(int i = 0; i < m; i++) {
            if(frequencyCount.getOrDefault(t.charAt(i),0)==0)
                return false;
            count = frequencyCount.get(t.charAt(i));
            frequencyCount.put(t.charAt(i),--count);
            if(count == -1)
                return false;
        }
        return true;
    }
}