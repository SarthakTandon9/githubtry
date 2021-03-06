public class peakindex {

    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    // solution to https://leetcode.com/problems/peak-index-in-a-mountain-array/ && https://leetcode.com/problems/find-peak-element/
    // 100% faster solution
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
}
