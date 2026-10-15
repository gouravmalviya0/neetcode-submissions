class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int ans = 0;

        if(nums[start] <= nums[end]) {
            return nums[start];
        }

        while(start < end) {
            
            int mid = start + (end - start)/2;

            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            } 
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if(nums[start] < nums[mid])   {
                start = mid+1;  
            } else {
                end = mid;
            }
        }

        return -1;
    }
}
