public class findRotationCount {
    //solution to https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

    public static int rotationCount(int[] arr){
        return pivotFinder(arr)+1;
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
}
