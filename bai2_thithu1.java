import java.util.Scanner;

public class bai2_thithu1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String s = in.nextLine();
        int n[] = new int[26];
        char c = in.next().charAt(0);
        int val = in.nextInt(), d = c - 97;
        for (int i=d; i<26; i++){
            if (val == 26)
                val = 0;
            n[i] = val;
            val++;
        }
        for (int i=0; i<d; i++){
            if (val == 26)
                val = 0;
            n[i] = val;
            val++;
        }
        int sum = 0;
        for (int i=0; i<s.length(); i++)
            sum += n[s.charAt(i) - 97];
        // for (int i=0; i<26; i++)
        //     System.out.println((char)(97+i) + " " + n[i] );
        System.out.println(sum);
    }
}

