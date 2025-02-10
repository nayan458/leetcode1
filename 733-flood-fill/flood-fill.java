class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        
        int rightEnd = image[0].length - 1, leftEnd=0, topEnd = 0, bottomEnd = image.length - 1;
        int imageColor = image[sr][sc];
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        st.push(new Pair<Integer, Integer>(sr,sc));

        while(!st.isEmpty()) {
            Pair<Integer, Integer> elem = st.pop();
            sr = elem.getKey(); 
            sc = elem.getValue();
            // move right
            if(sc != rightEnd && image[sr][sc + 1] == imageColor)
                st.push(new Pair<Integer,Integer>(sr,sc+1));
            // move left
            if(sc != leftEnd && image[sr][sc - 1] == imageColor)
                st.push(new Pair<Integer,Integer>(sr,sc-1));
            // move top
            if(sr != topEnd && image[sr - 1][sc] == imageColor)
                st.push(new Pair<Integer,Integer>(sr-1,sc));
            // move bottom
            if(sr != bottomEnd && image[sr + 1][sc] == imageColor)
                st.push(new Pair<Integer,Integer>(sr+1,sc));
            
            image[sr][sc] = color;
        }
        return image;
    }
}





























// class Solution {
//     // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//     //     int r = image.length;
//     //     int c = image[0].length;
//     //     int s_color = image[sr][sc];

//     //     if(s_color == color)
//     //         return image;
//     //     image[sr][sc] = color;
//     //     // right
//     //     if(sc < (c-1))
//     //         if(image[sr][sc+1] == s_color)
//     //             floodFill(image, sr, sc+1, color);
//     //     // left
//     //     if(sc > 0)
//     //         if(image[sr][sc-1] == s_color)
//     //             floodFill(image, sr, sc-1, color);
//     //     // top
//     //     if(sr < (r-1))
//     //         if(image[sr+1][sc] == s_color)
//     //             floodFill(image, sr+1, sc, color);
//     //     // bottom
//     //     if(sr > 0)
//     //         if(image[sr-1][sc] == s_color)
//     //             floodFill(image, sr-1, sc, color);

//     //     return image;
//     // }
//        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int img=image[sr][sc];
//         int row=image.length,col=image[0].length;
//         image[sr][sc]=color;
//         if(sr<row-1)
//             if(image[sr+1][sc]==img)
//                 floodFill(image,sr+1,sc,color);
//         if(sr>0)
//             if(image[sr-1][sc]==img)
//                 floodFill(image,sr-1,sc,color);
//         if(sc<col-1)
//             if(image[sr][sc+1]==img)
//                 floodFill(image,sr,sc+1,color);
//         if(sc>0)
//             if(image[sr][sc-1]==img)
//                  floodFill(image,sr,sc-1,color);
//         return image;
//     }
// }