import java.math.BigInteger;
import java.util.Scanner;

public class bai1_thithu1 {
    static Scanner in = new Scanner (System.in);
    public static void main(String[] args) {
        // String temp1 = in.next(), temp2 = in.next();
        // BigInteger a = new BigInteger(temp1), b = new BigInteger(temp2);
        BigInteger a = in.nextBigInteger(), b = in.nextBigInteger();
        BigInteger x = a.add(b);
        if (x.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
            x = x.divide(new BigInteger("2"));
            System.out.println(x + " " + a.subtract(x));
        }
        else 
            System.out.println("NOT FOUND");

    }

}
