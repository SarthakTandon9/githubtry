public class searchInMountain {
    //code with the basic logic implemented
    public static int searchInMountainArray(int[] arr, int target){
        int indexOfPeak = peakIndexInMountainArray(arr);

        int firstIndex = BinarySearch(arr, target, 0, indexOfPeak);
        if(firstIndex != -1){
            return firstIndex;
        }
        //try to search in second half.
        return BinarySearch(arr, target, indexOfPeak, arr.length-1);
    }
    static int BinarySearch(int[] arr, int target, int start, int end) {

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;

        while(start<end){
            int mid = start+(end-start)/2;

            if(arr[mid]>arr[mid+1]){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    //implementation of the API as described on LEETCODE


//    /**
//     * // This is MountainArray's API interface.
//     * // You should not implement it, or speculate about its implementation
//     * interface MountainArray {
//     *     public int get(int index) {}
//     *     public int length() {}
//     * }
//     */
//
//    class Solution {
//        public int findInMountainArray(int target, MountainArray mountainArr) {
//
//            int indexOfPeak = peakIndexInMountainArray(mountainArr);
//
//            int firstIndex = BinarySearch(mountainArr, target, 0, indexOfPeak);
//            if(firstIndex != -1){
//                return firstIndex;
//            }
//            //try to search in second half.
//            return BinarySearch(mountainArr, target, indexOfPeak, mountainArr.length()-1);
//        }
//
//
//        static int BinarySearch(MountainArray mountainArr, int target, int start, int end) {
//
//            // find whether the array is sorted in ascending or descending
//            boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
//
//            while(start <= end) {
//                // find the middle element
////            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
//                int mid = start + (end - start) / 2;
//
//                if (mountainArr.get(mid) == target) {
//                    return mid;
//                }
//
//                if (isAsc) {
//                    if (target < mountainArr.get(mid)) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                } else {
//                    if (target > mountainArr.get(mid)) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                }
//            }
//            return -1;
//        }
//        public static int peakIndexInMountainArray(MountainArray mountainArr) {
//            int start = 0, end = mountainArr.length()-1;
//
//            while(start<end){
//                int mid = start+(end-start)/2;
//
//                if(mountainArr.get(mid)>mountainArr.get(mid+1)){
//                    end = mid;
//                } else {
//                    start = mid+1;
//                }
//            }
//            return start;
//        }
//    }
}
