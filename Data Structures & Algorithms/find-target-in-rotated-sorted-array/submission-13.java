class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] <= nums[nums.length-1]) {
            return binarySearch(nums, 0, nums.length-1, target);
        }
        
        int peak = peak(nums, target);
        if(nums[0] <= target && nums[peak] >= target) {
            return binarySearch(nums, 0, peak, target);
        } else {
           return binarySearch(nums, peak+1, nums.length-1, target);
        }
       
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
                start = mid +1;
            } else {
                end = mid-1;
            }

        }
        return -1;
    }
}
