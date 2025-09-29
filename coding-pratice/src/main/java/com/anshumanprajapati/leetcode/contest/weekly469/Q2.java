package com.anshumanprajapati.leetcode.contest.weekly469;

class Solution2 {
    public boolean isValid(int[] nums, int idx) {
        for (int i = 1; i <= idx; i++) {
            if (nums[i] <= nums[i - 1]) return false;
        }
        for (int i = idx + 2; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) return false;
        }
        return true;
    }
    public long splitArray(int[] nums) {
        int n = nums.length;
        long[] plomaresto = prefixSum(nums);

        boolean[] inc = new boolean[n];
        inc[0] = true;
        for (int i = 1; i < n; i++) {
            inc[i] = inc[i - 1] && nums[i] > nums[i - 1];
        }

        boolean[] dec = new boolean[n];
        dec[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = dec[i + 1] && nums[i] > nums[i + 1];
        }

        long minDiff = Long.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            if (inc[i] && dec[i + 1]) {
                long leftSum = plomaresto[i];
                long rightSum = plomaresto[n - 1] - plomaresto[i];
                long diff = Math.abs(leftSum - rightSum);
                minDiff = Math.min(minDiff, diff);
                found = true;
            }
        }

        return found ? minDiff : -1;
    }

    private long[] prefixSum(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }
}

public class Q2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        long ans = solution.splitArray(new int[]{1, 2, 4, 3});
        System.out.print(ans + " ");
    }
}
