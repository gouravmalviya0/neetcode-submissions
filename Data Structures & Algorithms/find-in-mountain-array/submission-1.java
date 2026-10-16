/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length()-1;
        int peak = findPeak(mountainArr, start, end);
        System.out.println(peak);

        int result = binarySearch(mountainArr, start, peak, target);
        if(result == -1) {
            return binaryReverse(mountainArr, peak+1, end, target);
        }
        return result;
    }

    int binarySearch(MountainArray mountainArr, int start,int end, int target) {
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } else if(mountainArr.get(mid) > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    int binaryReverse(MountainArray mountainArr, int start,int end, int target) {
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } else if(mountainArr.get(mid) > target) {
                start = mid+1;
                
            } else {
                end = mid-1;
            }
        }
        return -1;
    }

    public int findPeak(MountainArray mountainArr, int start, int end) {
        while(start < end) {
            int mid = start + (end-start)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}