class Solution {
    public String removeOccurrences(String s, String part) {
        int[] LSP = createLSP(part);
        // List<Integer> index = KMP(s, part, LSP);
        StringBuffer ans = new StringBuffer(s);
        int index = KMP(s, part, LSP);

        while(index != -1){
            
            // for(Integer ind: index){
            //     int cut = ind - (i*part.length());
            ans.delete(index, index + part.length());
                // System.out.println(cut + " " + (cut + part.length()));
            //     i++;
            // }
            index = KMP(ans.toString(), part, LSP);
        }
        return ans.toString();
    }

    private int KMP(String str, String pattern, int[] LSP){
        int pp = 0;  // pattern pointer
        int sp = 0;  // string pointer
        
        while(sp < str.length()){
            if(str.charAt(sp) == pattern.charAt(pp)){
                pp++;
                sp++;
            } else {
                if(pp > 0)
                    pp = LSP[pp - 1];
                else
                    sp++;
            }
            if(pp == pattern.length()){ //match
                return (sp - pp);
                // pp = 0;
            }
        }

        return -1;
    }

    // private List<Integer> KMP(String str, String pattern, int[] LSP){
    //     int pp = 0;  // pattern pointer
    //     int sp = 0;  // string pointer
    //     List<Integer> index = new ArrayList<>();
        
    //     while(sp < str.length()){
    //         if(str.charAt(sp) == pattern.charAt(pp)){
    //             pp++;
    //             sp++;
    //         } else {
    //             if(pp > 0)
    //                 pp = LSP[pp - 1];
    //             else
    //                 sp++;
    //         }
    //         if(pp == pattern.length()){ //match
    //             index.add(sp - pp); 
    //             pp = 0;
    //         }
    //     }

    //     return index;
    // }
    private int[] createLSP(String pattern){
        int[] LSP = new int[pattern.length()];
        int pp = 1, lp = 0;
        while(pp < pattern.length()){
            if(pattern.charAt(pp) == pattern.charAt(lp)){
                LSP[pp++] = ++lp;
            } else{
                if(lp > 0){
                    lp = LSP[lp - 1];
                } else{
                    pp++;
                }
            }
        }
        return LSP;
    }
}