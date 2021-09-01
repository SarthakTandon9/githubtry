import java.util.*;

public class singleElement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        singleElement element = new singleElement();
        disp(element.negChange(element.input()));
    }
       public int[] input(){
           System.out.println("Enter the length of the array: ");
           int len = sc.nextInt();

           int[] arr = new int[len];

           for(int i = 0; i<len; i++){
               System.out.println("Enter element number " + (i+1));
               arr[i] = sc.nextInt();
           }
           return arr;
       }
       public int[] negChange(int[] arr){
           int[] retVal = arr; //making a copy because we do not modify the input array.
           int temp;

           for(int i = 0; i<arr.length; i++){
               if(retVal[i]<0){
                   temp = retVal[i];
                   for(int j = i-1; j >= 0; j--){
                       retVal[j+1] = retVal[j];
                   }
                   retVal[0] = temp;
               } else{
                   continue;
               }
           }
           return retVal;
       }

       public static void disp(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
       }
}
