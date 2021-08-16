import java.util.*;

public class Arrays {
    //Java algorithm to solve 34. Find First and Last Position of Element in Sorted Array on Leetcode
    //this solution uses a modified binary search algortithm to achieve its goal.
    public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1, value = -1, counter = 0;
        if(nums.length == 0){
            return new int[] {-1, -1};
        }
        while(start<=end){

            int mid = start + (end-start)/2;
            if(target<nums[mid]){
                end = mid - 1;
            } else if(target>nums[mid]){
                start = mid+1;
            } else if(nums[mid] == target){
                value = mid;
                end = mid-1;
            } else break;
        }
        for(int i = value+1; i<nums.length; i++){
            if(nums[i] == target){
                ++counter;
            } else break;
        }
        if(value == -1){
            return new int[] {-1, -1};
        }
        return new int[] {value, value+counter};
    }
}


