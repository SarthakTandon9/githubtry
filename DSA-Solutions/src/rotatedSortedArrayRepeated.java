public class rotatedSortedArrayRepeated {
    //copying the find pivot method.
    //solution to leetcode problem https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    //java 100% faster

    public static boolean search(int[] nums, int target){
        if(nums.length == 1) return nums[0] == target;
        int pivot = pivotFinderWithDuplicates(nums);
        //if pivot not found, arr is not rotated.
        if(pivot == -1) // do normal binary search.
            return binarySearch(nums, target, 0, nums.length-1) != -1 ? true: false;

        //if pivot is found, you have found two ascendind sorted arrays.

        if(nums[pivot] == target)
            return true;
        else if(nums[0] <= target)
            return binarySearch(nums, target, 0, pivot-1) != -1 ? true: false;

        return binarySearch(nums, target, pivot+1, nums.length-1) != -1 ? true: false;
    }
    public static int pivotFinderWithDuplicates(int[] arr){
        int start = 0, end = arr.length - 1;

        while(start<=end){
            //4 cases
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            } else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
            //if the elements at mid, start and end are duplicates, we skip those.
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates ONLY after confirming start and end are not the pivots

                if(arr[start]>arr[start+1])
                    return start;
                else
                    start++;
                //checking if end is pivot
                if(arr[end-1]>arr[end])
                    return end-1;
                else
                    end--;
            } else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            } else{
                end = mid-1;
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
