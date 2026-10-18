class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;

        while(i<nums.length) {
            if(i+1 == nums[i] || nums[i] == nums[nums[i]-1]) {
                i++;
            } else {
                swap(nums, i, nums[i]-1);
            }
        }
        //System.out.println(Arrays.toString(nums));
        
        for(i = 0;i<nums.length;i++){
            if(nums[i] != i+1) {
                return nums[i];
            }
        }

        return -1;
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
