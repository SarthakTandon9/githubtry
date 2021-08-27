public class prime {
    public static void main(String[] args) {
        System.out.println(isPrime(39));
        isPrime(1, 10);
    }

    public static boolean isPrime(int n){
       if(n==1 || n == 0){
           return false;
       }

       int i = 2;
       while(i*i<=n){
           if(n%i == 0)
               return false;
           ++i;
       }
       return true;
    }

    public static void isPrime(int n1, int n2){
        for(int i = n1; i<=n2; i++){
            if(isPrime(i)){
                System.out.println(i + " is a Prime Number. ");
            } else{
                System.out.println(i + " is not a Prime Number. ");
            }
        }
    }

}
