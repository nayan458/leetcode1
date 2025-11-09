class Solution {
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0)
            return 0;
        int count = num1/num2;
        return count + countOperations(num2, num1%num2);
    }
}