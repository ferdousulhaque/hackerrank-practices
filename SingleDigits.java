public class SingleDigits {

    // Iterative Solution for Digits
    static void findDigitsIterative(int n) {
        while(n>0){
            int rem = n % 10;
            n /=10;
            System.out.println(rem);    
        }
    }

    static void findDigitsRecursive(int n) {
        if((n/10)>0){
            findDigitsRecursive(n/10);
        }
        System.out.println(n%10);
    }

    static void findDigitsStringConvertion(int n) {
        for(char c: String.valueOf(n).toCharArray()){
            System.out.println(String.valueOf(c));
        }
    }

    public static void main(String[] args){
        //findDigitsRecursive(12345);
        //findDigitsIterative(12345);
        findDigitsStringConvertion(12345);
    }
}
