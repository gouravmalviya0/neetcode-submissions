class Solution {
    public int missingNumber(int[] nums) {
        int  i = 0;
        while(i<nums.length) {
            if(nums[i] == i) {
                i++;
            } else if ((nums[i] == nums.length)) {
                i++;
            } else {
                swap(nums, i, nums[i]);
            }
        }

int no = nums.length;
        for(int k=0;k<nums.length;k++) {
            if(nums[k] != k) {
             no =  k;
             break;
            }
        }

        return no;
    }

    void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
