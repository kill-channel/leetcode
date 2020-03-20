//Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruple
//ts in the array which gives the sum of target.
//
// Note:
//
// The solution set must not contain duplicate quadruplets.
//
// Example:
//
//
//Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics Array Hash Table Two Pointers


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int left = 0; left < nums.length - 3; left++) {
            for (int right = left + 3; right < nums.length; right++) {
                for (int medium = left + 1; medium < right; medium++) {
                    if (hashmap.containsKey(nums[medium])) {
                        List<Integer> current = Arrays.asList(nums[left], hashmap.get(nums[medium]), nums[medium], nums[right]);
                        Collections.sort(current);
                        ans.add(current);
                    } else {
                        hashmap.put(target - nums[left] - nums[right] - nums[medium], nums[medium]);
                    }
                }
                hashmap.clear();
            }
        }
        return new ArrayList<>(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
