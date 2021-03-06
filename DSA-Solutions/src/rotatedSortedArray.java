public class rotatedSortedArray {
    // solution to https://leetcode.com/problems/search-in-rotated-sorted-array/
    // 100% faster

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(pivotFinder(arr));
    }

    public static int search(int[] nums, int target){
        int pivot = pivotFinder(nums);
        //if pivot not found, arr is not rotated.
        if(pivot == -1) // do normal binary search.
            return binarySearch(nums, target, 0, nums.length-1);

        //if pivot is found, you have found two ascendind sorted arrays.

        if(nums[pivot] == target)
            return pivot;
        else if(nums[0] <= target)
            return binarySearch(nums, target, 0, pivot-1);

        return binarySearch(nums, target, pivot+1, nums.length-1);
    }
    public static int pivotFinder(int[] arr){
        int start = 0, end = arr.length - 1;

        while(start<=end){
            //4 cases
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            } else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
