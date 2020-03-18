//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// Related Topics Array Two Pointers


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        Set<List<Integer>> ans  = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(hashmap.containsKey(nums[j])){
                    List<Integer>current = Arrays.asList(nums[i], hashmap.get(nums[j]), nums[j]);
                    Collections.sort(current);
                    ans.add(current);
                }
                else{
                    hashmap.put(-nums[i] - nums[j], nums[j]);
                }
            }
            hashmap.clear();
        }
        return new ArrayList<>(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
