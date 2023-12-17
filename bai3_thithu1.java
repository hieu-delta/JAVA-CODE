import java.util.Arrays;
import java.util.Scanner;

class DanhSachDonHang implements Comparable<DanhSachDonHang>{
    static int order = 1;
    String id, name, unit;
    long buy, sell, profit;

    DanhSachDonHang (String name, String unit, String buy, String sell){
        this.id = String.format("DH%03d", order++);
        this.name = name;
        this.unit = unit;
        this.buy = Long.valueOf(buy);
        this.sell = Long.valueOf(sell);
        this.profit = this.sell - this.buy;
    }

    public int compareTo (DanhSachDonHang x){
        if (this.profit != x.profit)
            return -Long.compare(this.profit, x.profit);
        else
            return this.id.compareTo(x.id);
    }

    public String toString (){
        return id + " " + name + " " + unit + " " + buy + " " + sell + " " + profit;
    }

} 

public class bai3_thithu1 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        in.nextLine();
        DanhSachDonHang a[] = new DanhSachDonHang[n];
        for (int i=0; i<n; i++){
            String name = in.nextLine();
            String unit = in.nextLine();
            String buy = in.nextLine();
            String sell = in.nextLine();
            a[i] = new DanhSachDonHang(name, unit, buy, sell);
        }
        Arrays.sort(a);
        for (DanhSachDonHang i : a)
            System.out.println(i);
    }
}
