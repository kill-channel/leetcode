//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its inde
//x, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int binary_search(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return binary_search(nums, target, start, mid - 1);
            }
            return binary_search(nums, target, mid + 1, end);
        }
        if (target > nums[mid] && target <= nums[end]) {
            return binary_search(nums, target, mid + 1, end);
        }
        return binary_search(nums, target, start, mid - 1);
    }

    public int search(int[] nums, int target) {
        return binary_search(nums, target, 0, nums.length - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
