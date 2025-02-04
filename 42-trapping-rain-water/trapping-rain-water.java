class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int water = 0;

        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; i++)
            leftMax[i] = Math.max(leftMax[i-1],height[i]);

        for(int i = (height.length - 2); i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        
        for(int i = 0; i < height.length; i++)
            water += Math.min(rightMax[i],leftMax[i]) - height[i];
        
        return water;
    }
}
// class Solution {
//     public int trap(int[] height) {
        
//         int water = 0, baseHeight = height[0];
//         Stack<Integer> st = new Stack<>();
//         Stack<Integer> st2 = new Stack<>();

//         st.push(height[0]);

//         for(int i = 1; i < height.length; i++) {
            
//             if(baseHeight <= height[i]) {
//                 while(!st.empty()){
//                     water += baseHeight - st.pop();
//                 }
//                 baseHeight = height[i];
//                 st.push(height[i]);
//             } else {
//                 st.push(height[i]);
//             }
//         }

//         baseHeight = st.pop();
//         while(!st.empty()) {
//             if(baseHeight <= st.peek()) {
//                 while(!st2.empty()){
//                     water += baseHeight - st2.pop();
//                 }
//                 baseHeight = st.pop();
//                 st2.push(baseHeight);
//             } else {
//                 st2.push(st.pop());
//             }
//         }

//         return water;
//     }
// }