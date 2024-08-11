class Solution {
    public String frequencySort(String s) {
        char []ch = s.toCharArray();
        Arrays.sort(ch);

        System.out.println("after sort");

        for( int i = 0 ; i < ch.length; i++)
            System.out.print(ch[i]);
        System.out.println();

        int size = 1;
        for( int i = 0; i < ch.length-1; i++)
            if(ch[i] != ch[i+1])
                ++size;

        int [] frequency = new int[size];
        char [] distChar = new char[size];
        
        frequency[0] = 1;
        distChar[0] = ch[0];

        for( int i = 0, j = 0; i < ch.length-1 ; i++){
            if(ch[i] == ch[i+1]){
                frequency[j] += 1;
                continue;
            }
            frequency[++j] += 1;
            distChar[j] = ch[i+1];
        }

        for(int i = 0; i < size; i++){
            System.out.print(distChar[i] + " " + frequency[i] + "\n");
        }
        System.out.println();

        int tempVar;
        char tempChar;
        for( int i = 0; i < size-1; i++){
            for( int j = 0; j < size - i - 1; j++ ){
                if(frequency[j] < frequency[j+1]){

                    // swap for frequency
                    tempVar = frequency[j];
                    frequency[j] = frequency[j+1];
                    frequency[j+1] = tempVar;
                    
                    // swap for chachr
                    tempChar = distChar[j];
                    distChar[j] = distChar[j+1];
                    distChar[j+1] = tempChar;
                }
            }
        }

        for(int i = 0; i < size; i++){
            System.out.print(distChar[i] + " " + frequency[i] + "\n");
        }

        int k = 0;
        for( int i = 0 ; i < size; i++){
            for( int j = 0; j < frequency[i]; j++)
                ch[k++] = distChar[i];
        }

        s = new String(ch);

        return s;
        
    }
}