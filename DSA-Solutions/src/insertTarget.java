public class insertTarget {
    //solution to problem https://leetcode.com/problems/search-insert-position/

    public static int searchInsert(int[] nums, int target) {
        return findCeiling(nums, target);
    }

    public static int findCeiling(int[] arr, int target){
        //returns the index of the ceiling.

        int start = 0, end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target>arr[mid]){
                start = mid+1;
            } else if(target<arr[mid]){
                end = mid-1;
            } else{
                return mid;
            }
        }
        return start;
    }
}
