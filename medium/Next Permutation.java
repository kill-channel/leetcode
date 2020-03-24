//Implement next permutation, which rearranges numbers into the lexicographicall
//y next greater permutation of numbers. 
//
// If such arrangement is not possible, it must rearrange it as the lowest possi
//ble order (ie, sorted in ascending order). 
//
// The replacement must be in-place and use only constant extra memory. 
//
// Here are some examples. Inputs are in the left-hand column and its correspond
//ing outputs are in the right-hand column. 
//
// 1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics Array


import java.lang.reflect.Array;

class Solution {
    public void nextPermutation(int[] nums) {
        nextPermute(nums, 0);
    }

    private boolean nextPermute(int[] nums, int i) {
        int size = nums.length;
        if (i == size - 1) return false;
        boolean isfind = nextPermute(nums, i + 1);
        if (isfind) return isfind;
        int target = nums[i];
        for (int j = i + 1; j < size; j++) {
            if (nums[j] > target) {
                nums[i] = nums[j];
                nums[j] = target;
                return true;
            }
        }
        System.arraycopy(nums, i + 1, nums, i, size - i - 1);
        nums[size-1]=target;
        return false;
    }

}
