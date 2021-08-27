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
            }//end of if.
            else if(target>nums[mid]){
                start = mid+1;
            }//end of else if.
            else if(nums[mid] == target){
                value = mid;
                end = mid-1;
            } // end of else if
            else break;
        }//end of while.
        for(int i = value+1; i<nums.length; i++){
            if(nums[i] == target) ++counter;
            else break;
        }//end of for.
        return value == -1? new int[] {-1, -1} : new int[]{value, value + counter};
        //return value.
    } // end of method.
}// end of class.


