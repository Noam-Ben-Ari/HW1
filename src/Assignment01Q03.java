public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int last = 1, sum = 0, numOdd = 0;
        for (int i = 0; i < x; i++) {
            System.out.print(last + " ");
            last += sum;
            sum = last - sum;
            
            if (last % 2 == 1) {
                numOdd++;
            }
        }
        System.out.println();
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
