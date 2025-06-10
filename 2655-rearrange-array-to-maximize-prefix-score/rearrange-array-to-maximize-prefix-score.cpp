class Solution {
public:
    int maxScore(vector<int>& nums) {
        long long int result = 0;
        int count = 0;
        sort(nums.begin(), nums.end(), greater<int>());
        for(auto x:nums){
            result += x;
            if(result <= 0)
                break;
            count += 1;
        }
        return count;
    }
};