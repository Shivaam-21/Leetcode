package LEETCODE;

import java.util.*;

class Solution {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int x = 0;

        while (x <= right) {
            if (nums[x] == 0) {
                swap(nums, left, x);
                left++;
                x++;
            } else if (nums[x] == 1) {
                x++;
            } else {
                swap(nums, x, right);
                right--;
            }
        }
    }

    // swap helper (needed in Java)
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // ✅ MAIN METHOD (INPUT + OUTPUT)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input size
        int n = sc.nextInt();

        // input array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        sol.sortColors(nums);

        // print output
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
