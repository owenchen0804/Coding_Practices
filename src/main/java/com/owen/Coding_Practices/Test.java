package com.owen.Coding_Practices;

import java.util.*;

import BinaryTree.TreeNode;
import LinkedList.*;

public class Test{

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int leftIndex = findSmallest(nums, i, lower, upper);
            int rightIndex = findLargest(nums, i, lower, upper);
            if (leftIndex == -1 || rightIndex == -1) continue;
            result += rightIndex - leftIndex + 1;
        }
        return result;
    }

    private int findSmallest(int[] nums, int i, int lower, int upper) {
        int left = i + 1, right = nums.length - 1;
        if (nums[i] + nums[left] > lower || nums[i] + nums[right] < upper) return -1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[i] + nums[mid] >= lower && nums[i] + nums[mid] <= upper) {
                right = mid;
            }
            else if (nums[i] + nums[mid] < lower) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int findLargest(int[] nums, int i, int lower, int upper) {
        int left = i + 1, right = nums.length - 1;
        if (nums[i] + nums[left] > lower || nums[i] + nums[right] < upper) return -1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[i] + nums[mid] >= lower && nums[i] + nums[mid] <= upper) {
                left = mid;
            }
            else if (nums[i] + nums[mid] < lower) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (nums[i] + nums[right] >= lower && nums[i] + nums[right] <= upper) return right;
        if (nums[i] + nums[left] >= lower && nums[i] + nums[left] <= upper) return left;
        return -1;
    }

    public static void main(String[] args) {




        Integer[] array = {0,1,4,4,5,7};
        //System.out.print(Long.compare(a, 1));
        Arrays.sort(array, (a, b) -> Integer.compare(b, a));
        System.out.println(array);
    }
}