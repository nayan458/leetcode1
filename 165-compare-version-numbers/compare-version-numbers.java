class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        for(int i = 0; i < Math.min(str1.length,str2.length); i++){
            int x = Integer.compare(
                Integer.parseInt(str1[i]),
                Integer.parseInt(str2[i]));
            if(x == 0) continue;

            else return x;
        }

        if(str1.length == str2.length)
            return 0;

        boolean v1 = check(str1, str2.length);
        boolean v2 = check(str2, str1.length);
        
        System.out.println(v1 + " " + v2);

        return v1 ? 1 : v2 ? -1 : 0;
    }

    public boolean check(String[] str, int x){
        for(int i = x; i < str.length && i >= 0; i++){
            System.out.println(Integer.parseInt(str[i]));
            if(Integer.parseInt(str[i]) > 0)
                return true;
        }
        return false;
    }
}