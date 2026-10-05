class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int k = n/2;
        int z = 1;
        Integer ans = null;
        for(int i = 0;i<n-1;i++) {
            if(nums[i] == nums[i+1]) {
                z++;
            } else {
                if (z > k) {
                    ans = nums[i];
                    break;
                }
               z = 1;
            }
        }
        if (ans == null)
         return nums[n - 1]; 
        return ans;
    }
}