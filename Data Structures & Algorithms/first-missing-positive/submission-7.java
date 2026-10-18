class Solution {
    public int firstMissingPositive(int[] nums) {
        int i =0;

        while(i < nums.length) {
            if(nums[i] > nums.length || i+1 == nums[i]  || (nums[i]-1 >= 0 && nums[i]-1 < nums.length && nums[i] == nums[nums[i]-1])) {
                i++;
            } else if(nums[i] > 0) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for(i = 0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}