class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 1) {
            return 1;
        }
        
        int counter = 1;
        int unique = 0;

        while(counter < nums.length) {
            if (nums[unique] != nums[counter]) {
                unique++;
               swap(nums, unique, counter);
            }
            counter++;
        }

        return unique+1;
        
    }

    void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}