class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] <= nums[nums.length-1]) {
            return binarySearch(nums, 0, nums.length-1, target);
        }
        
        int peak = peak(nums, target);
         
        System.out.println(peak);
        int ans = -1;
        if (peak != -1 && target >= nums[0]) 
        ans = binarySearch(nums, 0, peak, target);
        
        if(ans == -1) 
        ans = binarySearch(nums, peak+1, nums.length-1, target);

        return ans;
    }

    int binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
        int mid = start + (end - start)/2;

        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            end = mid -1;
        } else {
            start = mid+1;
        }
        }

        return -1;
    }


    public int peak(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(mid < nums.length-1 && nums[mid] > nums[mid+1]) {
               return mid; 
            }

            if(mid > 0 && nums[mid] < nums[mid-1]) {
               return mid-1; 
            }

            if(nums[mid] > nums[start]) {
                start = mid;
            } else {
                end = mid-1;
            }

        }
        return -1;
    }
}
